
package toString;

public class toString {

	public static final int DIM = 3;
	private static final String[] NUMBERING = { " 0 | 1 | 2 ", "---+---+---", " 3 | 4 | 5 ", "---+---+---",
			" 6 | 7 | 8 " };
	private static final String LINE = NUMBERING[1];
	private static final String DELIM = "     ";
	private Mark[] fields;

	public String toString() {
		String s = "";
		for (int i = 0; i < DIM; i++) {
			String row = "";
			for (int j = 0; j < DIM; j++) {
				row = row + " " + getField(i, j).toString() + " ";
				if (j < DIM - 1) {
					row = row + "|";
				}
			}

			s = s + row + DELIM + NUMBERING[i * 2];
			if (i < DIM - 1) {
				s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
			}
		}
		return s;
	}

	public Mark getField(int row, int col) {
		// TODO: implement, see exercise P-4.18
		return null;
	}

}
