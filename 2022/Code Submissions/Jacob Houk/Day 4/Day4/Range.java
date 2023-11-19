package Day4;

public class Range {
	String range;
	int dInd;
	
	public Range(String range) {
		this.range = range;
		
		for (int i = 0; i < range.length(); i++) {
			if (range.charAt(i) == '-') {
				this.dInd = i;
				break;
			}
		}
	}
	
	public String getRange() {
		return this.range;
	}
	
	public int getDInd() {
		return this.dInd;
	}
	
	public boolean inside(Range r2) {
		int start1 = Integer.parseInt(this.getRange().substring(0, this.getDInd()));
		int end1 = Integer.parseInt(this.getRange().substring(this.getDInd() + 1));
		int start2 = Integer.parseInt(r2.getRange().substring(0, r2.getDInd()));
		int end2 = Integer.parseInt(r2.getRange().substring(r2.getDInd() + 1));
		
		if (end2 >= end1 && start2 <= start1) {
			return true;
		}
		
		return false;
	}
	
	//(s1 <= e2 && e1 >= s2) || (e1 <= s2 && s1 >= e2)
	
	public boolean overlap(Range r2) {
		int start1 = Integer.parseInt(this.getRange().substring(0, this.getDInd()));
		int end1 = Integer.parseInt(this.getRange().substring(this.getDInd() + 1));
		int start2 = Integer.parseInt(r2.getRange().substring(0, r2.getDInd()));
		int end2 = Integer.parseInt(r2.getRange().substring(r2.getDInd() + 1));
		
		if ((start1 <= end2 && end1 >= start2) || (end1 <= start2 && start1 >= end2)) {
			return true;
		}
		
		return false;
	}
}