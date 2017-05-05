public class Node implements Comparable<Node>{
	public String key = "";
	public int frequency = 0;
	public Node left;
	public Node right;
	
	Node(String k, int f){
		this.key = k;
		this.frequency = f;
	}
	public String toString(){
		return key+" "+frequency;
	}
	public int compareTo(Node n) {
        return n.frequency < this.frequency ? 1 : (n.frequency == this.frequency ? 0 : -1);
    }
}