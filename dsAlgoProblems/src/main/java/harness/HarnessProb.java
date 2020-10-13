package harness;

import java.util.*;

public class HarnessProb {

	class Tree {
		public TreeNode root;
		public long treeId;
	}

	class TreeNode {
		List<TreeNode> children;
		int data;
	}

	class TreeDetails {
		public TreeDetails(Tree tree, int minSum) {

			this.tree = tree;
			this.minSum = minSum;
		}

		Tree tree;
		int minSum;
	}

	interface TreeOperator {

		// store to any data structure of your choice

		void add(List<Tree> roots);

		// remove the Tree with the given Id from the your data structure if already
		// present else nothing to do

		void remove(long treeId);

		// return the Tree which has min sum of root to leaf path, within the given id
		// range

		Tree findMinPathTree(long treeIdLeft, long treeIdRight);
	}

	class TreeOperatorDemo implements TreeOperator {
		TreeMap<Long, TreeDetails> allTrees;

		TreeOperatorDemo() {
			allTrees = new TreeMap<>();
		}

		public void add(List<Tree> roots) {
			for (Tree tree : roots) {
				int minSum = calculateMinSum(tree);
				TreeDetails treeDetails = new TreeDetails(tree, minSum);
				allTrees.put(tree.treeId, treeDetails);
			}

		}

		// remove the Tree with the given Id from the your data structure if already
		// present else nothing to do

		public void remove(long treeId) {
			allTrees.remove(treeId);

		}

		// return the Tree which has min sum of root to leaf path, within the given id
		// range
		//USE subMap() method of TreeMap class.
		public Tree findMinPathTree(long treeIdLeft, long treeIdRight) {
			TreeDetails minTreeDetails = null;

			//USE subMap() method of TreeMap class.
			//What hapeens all the 3 methods in TreeOperatorDemo is exposed as APIs and 
			//are accessed concurrently? subMap() method returns a new map. So, no issues with concurrency.
			for (Long treeId = allTrees.ceilingKey(treeIdLeft); treeId != null
					&& treeId <= treeIdRight; treeId = allTrees.ceilingKey(treeId)) {

				if (minTreeDetails == null) {
					minTreeDetails = allTrees.get(treeId);
				} else if (minTreeDetails.minSum > allTrees.get(treeId).minSum) {
					minTreeDetails = allTrees.get(treeId);
				}

			}
			return minTreeDetails == null ? null : minTreeDetails.tree;
		}

		//This calculateMinSum method implementation is wrong. Update it with this solution.
		//https://massivealgorithms.blogspot.com/2016/02/buttercola-indeed-n-ary-tree-root-to.html

		public int calculateMinSum(Tree tree)
		{
			TreeNode treeNode = tree.root;
			List<TreeNode> children = treeNode.children;
			int minSum = treeNode.data;
			while(children!=null && children.size()>0)
			{
				int i=children.size();
				List<TreeNode> nextChildren = new ArrayList<>();
				int curSum = minSum+children.get(0).data;
				for(int j=0; j<i; j++)
				{
					if(curSum>minSum+ children.get(j).data)
					{
						curSum = minSum+ children.get(j).data;
					}
					nextChildren.addAll(children.get(j).children);
				}
				children = nextChildren;
				minSum = curSum;
			}
			
			return minSum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
