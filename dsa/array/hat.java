package dsa.array;

import java.util.HashSet;

public class hat{
    


        static HashSet<String> seen = new HashSet<>(); // Store unique transformations
    
        // Function to replace consecutive '1's with their count
        public static String compressOnes(String s) {
            return s.replaceAll("1+", match -> String.valueOf(match.group().length())); // Compress '1's
        }
    
        // Recursive function to generate transformations
        public static void generateReplacements(String s, int index) {
            if (index == s.length()) return; // Base case: stop when index reaches end
    
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) != '1') { // Replace only non-'1' characters
                    char[] arr = s.toCharArray();
                    arr[i] = '1';
                    String transformed = compressOnes(new String(arr));
    
                    if (seen.add(transformed)) { // Avoid duplicates
                        System.out.println(transformed);
                        generateReplacements(new String(arr), i + 1); // Recur for next index
                    }
                }
            }
        }
    
        public static void main(String[] args) {
            String s = "hat";
            generateReplacements(s, 0);
        }
    }

    