package stringalgorithms;

public class PathDirectory {
    public static void main(String arg[]) {
        PathDirectory pathDirectory = new PathDirectory();
       /* System.out.println(pathDirectory.simplifyPath("/home/"));
        System.out.println(pathDirectory.simplifyPath("/a/./b/../../c/"));*/
        //System.out.println(pathDirectory.simplifyPath("/../"));
        System.out.println(pathDirectory.simplifyPath("/home//foo//boo/"));
        System.out.println(pathDirectory.simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String A) {
            String[] strArray;
            String ans = "";
            if (A.contains("//")) {
                strArray = A.split("//");
                int i = 0;
                while (i < strArray.length) {
                    if (strArray[i].startsWith("/")) {
                        ans += strArray[i];
                    } else {
                        ans += "/" + strArray[i];
                    }
                    i++;
                }
                return ans.substring(0, ans.length() - 1);
            }
            strArray = A.split("/");
            int n = strArray.length;
            ans = strArray[n - 1];
            if (ans.equals("..") || ans.equals(".")) {
                ans = "/";
            } else {
                ans = "/" + ans;
            }
            return ans;
    }
}
