package hashing;

import java.util.HashMap;

public class WindowString {
    public String minWindow(String A, String B) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            count++;
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int min_len = -1, index = -1, left = 0, right = 0;
        while (right < A.length()) {
            char charAt = A.charAt(right);
            if (map.containsKey(charAt)) {
                if (map.get(charAt) > 0) {
                    count--;
                }
                map.put(charAt, map.get(charAt) - 1);
            }
            while (count == 0) {
                int len = right - left + 1;
                if (index == -1 || min_len > len) {
                    min_len = len;
                    index = left;
                }
                char charAt1 = A.charAt(left);
                if (map.containsKey(charAt1)) {
                    if (map.get(charAt1) >= 0) {
                        count++;
                    }
                    map.put(charAt1, map.get(charAt1) + 1);
                }
                left++;
            }
            right++;
        }

        if (index == -1) {
            return "";
        }
        return A.substring(index, index + min_len);
    }

    public static void main(String args[]) {
        WindowString windowString = new WindowString();
        /*System.out.println(windowString.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(windowString.minWindow("Aa91b", "ab"));*/

        System.out.println(windowString.minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh"
                , "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));
    }

}
