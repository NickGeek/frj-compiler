# Make the generator by running:
# grammarinator-process ../../main/antlr4/FRJLexer.g4 ../../main/antlr4/FRJSimpleParser.g4 -o .

SCRIPT_DIR=$(dirname "$(readlink -f "$0")")
cd "$SCRIPT_DIR" || exit
grammarinator-generate 'FRJGenerator.FRJGenerator' \
-r program \
-n 1000 \
-d 300 \
-j 12 \
-s "grammarinator.runtime.simple_space_serializer" \
--sys-path="$SCRIPT_DIR" \
-o "$SCRIPT_DIR"/../resources/fuzzTestCases
