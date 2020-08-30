package codegen;

import lombok.AllArgsConstructor;
import std.Builtins;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.*;

@AllArgsConstructor
public class Bundler {
	private final String name;

	public void makeJar(Path workingDir) throws IOException {
		var manifest = this.makeManifest();
		var outputFile = Path.of("out.jar").toFile();
		var os = new JarOutputStream(new FileOutputStream(outputFile), manifest);

		// Place compiled code into the JAR
		Files.walk(workingDir)
				.forEach(path -> {
					try {
						var relativePath = workingDir.relativize(path).toString();
						if (relativePath.length() == 0) return;

						if (path.toFile().isFile()) {
							os.putNextEntry(new JarEntry(relativePath));
							os.write(Files.readAllBytes(path));
							os.closeEntry();
						} else if (path.toFile().isDirectory()) {
							var entryName = relativePath.endsWith("/") ? relativePath : relativePath + "/";
							os.putNextEntry(new JarEntry(entryName));
							os.closeEntry();
						}
					} catch (IOException e) {
						throw new RuntimeException("I/O Exception encountered whilst building JAR.\n" + e);
					}
				});

		// Extract the runtime into the JAR
		var runtimeJarIs = new JarInputStream(Builtins.class.getResourceAsStream("/runtime.jar"));
		Set<String> addedFiles = new HashSet<>();
		var entry = runtimeJarIs.getNextJarEntry();
		while (entry != null) {
			if (entry.getRealName().equals("MANIFEST.MF") || addedFiles.contains(entry.getRealName())) {
				entry = runtimeJarIs.getNextJarEntry();
				continue;
			}
			addedFiles.add(entry.getRealName());

			if (entry.isDirectory()) {
				var entryName = entry.getRealName().endsWith("/") ? entry.getRealName() : entry.getRealName() + "/";
				os.putNextEntry(new JarEntry(entryName));
			} else {
				os.putNextEntry(entry);
				var byteLength = 0;
				var buffer = new byte[2048];
				while ((byteLength = runtimeJarIs.read(buffer)) > 0) {
					os.write(buffer, 0, byteLength);
				}
			}
			os.closeEntry();

			entry = runtimeJarIs.getNextJarEntry();
		}
		runtimeJarIs.close();

		os.close();

		// Remove intermediate files
		Files.walk(workingDir)
				.sorted(Comparator.reverseOrder())
				.forEach(path -> {
					try {
						Files.delete(path);
					} catch (IOException e) {
						System.err.println("Warning: Could not remove " + path.toString());
					}
				});
	}

	private Manifest makeManifest() {
		var manifest = new Manifest();
		var attributes = manifest.getMainAttributes();
		attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0.0");
		attributes.put(Attributes.Name.MAIN_CLASS, this.name);

		return manifest;
	}
}
