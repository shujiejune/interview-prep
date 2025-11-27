/* Print all subsets of a set. 
 * Assumption: no duplicate characters in the set.
 * */
public List<String> subSets(String set) {
  List<String> ans = new ArrayList<>();
  if (set == null) {
    return ans;
  }
  if (set.length() == 0) {
    ans.add(set);
    return ans;
  }
  dfs(set, 0, new StringBuilder(), ans);
  return ans;
}

private void dfs(String set, int index, StringBuilder s, List<String> ans) {
  if (index == set.length()) {
    ans.add(s.toString());
    return;
  }
  s.append(set.charAt(index));
  dfs(set, index + 1, s, ans);
  s.deleteCharAt(s.length() - 1);
  dfs(set, index + 1, s, ans);
}
