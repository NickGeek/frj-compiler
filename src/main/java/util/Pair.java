package util;

import lombok.Value;

@Value
public class Pair<A, B> {
	A first;
	B second;
}
