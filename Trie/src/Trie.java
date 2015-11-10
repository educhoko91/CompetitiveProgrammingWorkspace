public class Trie {
	/*
	 * 
	 * ********
	 * * TRIE * 
	 * ********
	 * 
	 * TEMPLATE: trie
	 */

	public static Nodo root = new Nodo();

	public static void addWord(Nodo vertex, StringBuilder word) {
		if (word.length() == 0) {
			vertex.words++;
		} else {
			vertex.prefixes++;
			int k = word.charAt(0) - 'a';
			if (vertex.edges[k] == null) {
				vertex.edges[k] = new Nodo();
			}
			addWord(vertex.edges[k], word.deleteCharAt(0));
		}
	}

	public static int countWords(Nodo vertex, StringBuilder word) {
		int k = word.charAt(0) - 'a';
		if (word.length() == 0) {
			return vertex.words;
		} else if (vertex.edges[k] == null) {
			return 0;
		} else {
			return countWords(vertex.edges[k], word.deleteCharAt(0));
		}
	}

	public static int countPrefixes(Nodo vertex, StringBuilder prefix) {
		int k = prefix.charAt(0) - 'a';
		if (prefix.length() == 0) {
			return vertex.prefixes;
		} else if (vertex.edges[k] == null) {
			return 0;
		} else {
			return countPrefixes(vertex.edges[k], prefix.deleteCharAt(0));
		}
	}

	static class Nodo {
		int words;
		int prefixes;
		Nodo[] edges = new Nodo[26];

		public Nodo() {
			this.words = 0;
			this.prefixes = 0;
			for (int i = 0; i < 26; i++) {
				this.edges[i] = null;
			}
		}
	}
}
