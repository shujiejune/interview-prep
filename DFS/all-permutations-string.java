/* Given a string without duplicate letters,
 * print out all permutations of the string.
 */
public List<String> permutations(String input) {
  Set<Character> chars = new HashSet<>();
  for (char c : input.toCharArray()) {
    chars.add(c);
  }
  List<String> ans = new ArrayList<>();
  dfs(chars, new StringBuilder(), ans);
  return ans;
}

private void dfs(Set<Character> chars, StringBuilder s, List<String> ans) {
  if (chars.size() == 0) {
    ans.add(s.toString());
    return;
  }
  Iterator<Character> iter = chars.iterator();
  while (iter.hasNext()) {
    char c = iter.next();
    s.append(c);
    chars.remove(c);
    dfs(chars, s, ans);
    chars.add(c);
    s.deleteCharAt(s.length() - 1);
  }
}

/* Why the solution above is incorrect:
 * Modifying the set while iterating through it.
 */

public List<String> permutations(String input) {
  List<String> ans = new ArrayList<>();
  if (input == null) {
    return ans;
  }
  char[] chars = input.toCharArray();
  Arrays.sort(chars);
  boolean[] visited = new boolean[input.length()];
  dfs(chars, visited, new StringBuilder(), ans);
  return ans;
}

private void dfs(char[] chars, boolean[] visited, StringBuilder s, List<Stirng> ans) {
  if (s.length() == chars.length) {
    ans.add(s.toString());
    return;
  }
  for (int i = 0; i < chars.length; i++) {
    if (visited[i]) { continue; }
    if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
      continue;
    }
    visited[i] = true;
    s.append(chars[i]);
    dfs(chars, visited, s, ans);
    s.deleteCharAt(s.length() - 1);
    visited[i] = false;
  }
}
