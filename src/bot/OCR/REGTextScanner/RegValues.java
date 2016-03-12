/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot.OCR.REGTextScanner;

import java.util.Arrays;

/**
 *
 * @author Preston Garno
 */
public class RegValues {
    /**
     * Array with number of pixels in each letter
     */
    public static final int[] dash = {1, 1, 1, 1, 1, 1};
    public static final int[] forwardSlash = {3, 6, 6, 5, 2};
    public static final int[] underScore = {1, 1, 1, 1, 1, 1, 1, 1};
    public static final int[] zero = {6, 8, 6, 4, 6, 8, 6};
    public static final int[] one = {2, 3, 10, 10, 1, 1};
    public static final int[] two = {3, 5, 4, 4, 5, 5, 3};
    public static final int[] three = {2, 5, 3, 3, 10, 7};
    public static final int[] four = {8, 8, 1, 6, 6, 1, 1};
    public static final int[] five = {5, 6, 3, 4, 7, 5};
    public static final int[] six = {6, 8, 6, 3, 6, 5, 2};
    public static final int[] seven = {3, 5, 5, 5, 4, 2};
    public static final int[] eight = {3, 7, 7, 3, 7, 7, 3};
    public static final int[] nine = {3, 5, 3, 2, 2, 10, 9};
    public static final int[] a = {3, 6, 3, 3, 6, 5};
    public static final int[] Acap = {8, 9, 3, 2, 3, 9, 8};
    public static final int[] b = {10, 10, 2, 3, 5, 3};
    public static final int[] Bcap = {10, 10, 3, 3, 10, 7};
    public static final int[] c = {4, 6, 2, 2, 2};
    public static final int[] Ccap = {6, 8, 4, 2, 4, 2};
    public static final int[] d = {3, 5, 3, 2, 10, 10};
    public static final int[] Dcap = {10, 10, 2, 3, 9, 7};
    public static final int[] e = {4, 6, 3, 3, 5, 3};
    public static final int[] Ecap = {10, 10, 3, 3, 2, 2};
    public static final int[] f = {2, 10, 10, 2, 2, 1};
    public static final int[] Fcap = {10, 10, 2, 2, 1, 1};
    public static final int[] g = {5, 8, 3, 3, 10, 8};
    public static final int[] Gcap = {6, 8, 4, 3, 3, 8, 5};
    public static final int[] h = {10, 10, 2, 1, 6, 5};
    public static final int[] Hcap = {10, 10, 1, 1, 10, 10};
    public static final int[] i = {6, 6};
    public static final int[] Icap = {2, 10, 10, 2};
    public static final int[] J = {2, 3, 1, 10, 9};
    public static final int[] Jcap = {3, 4, 2, 10, 9, 1, 1};
    public static final int[] k = {10, 10, 3, 4, 3, 1};
    public static final int[] Kcap = {10, 10, 4, 4, 4, 3, 1};
    public static final int[] l = {10, 10};
    public static final int[] Lcap = {10, 10, 1, 1, 1, 1};
    public static final int[] m = {5, 6, 1, 6, 6, 1, 6, 5};
    public static final int[] Mcap = {10, 10, 2, 2, 2, 2, 10, 10};
    public static final int[] n = {6, 6, 2, 1, 6, 5};
    public static final int[] Ncap = {10, 10, 3, 5, 5, 10, 10};
    public static final int[] o = {4, 6, 2, 2, 6, 4};
    public static final int[] Ocap = {0, 6, 8, 4, 2, 4, 8, 6, 0};
    public static final int[] p = {9, 10, 2, 2, 6, 4};
    public static final int[] Pcap = {10, 10, 2, 4, 4, 2};
    public static final int[] q = {2, 4, 4, 2, 10, 9};
    public static final int[] Qcap = {0, 6, 8, 5, 4, 5, 9, 7};
    public static final int[] r = {6, 6, 2, 1};
    public static final int[] Rcap = {10, 10, 3, 5, 8, 5};
    public static final int[] s = {2, 4, 3, 3, 5, 3};
    public static final int[] Scap = {2, 5, 5, 5, 6, 3};
    public static final int[] t = {8, 9, 2, 2};
    public static final int[] Tcap = {1, 1, 10, 10, 1, 1};
    public static final int[] u = {5, 6, 1, 1, 6, 5};
    public static final int[] Ucap = {8, 9, 2, 1, 2, 10, 10};
    public static final int[] v = {2, 4, 4, 4, 4, 2};
    public static final int[] Vcap = {5, 8, 5, 5, 8, 5};
    public static final int[] W = {5, 6, 2, 2, 2, 6, 5};
    public static final int[] Wcap = {8, 9, 2, 6, 6, 2, 9, 8};
    public static final int[] x = {2, 5, 4, 4, 5, 2};
    public static final int[] y = {5, 7, 2, 3, 9, 8};
    public static final int[] Ycap = {3, 4, 7, 7, 4, 3};
    public static final int[] z = {3, 4, 4, 4, 3, 2};
    public static final int[] Zcap = {4, 6, 4, 5, 5, 3};

    public static char getMatch(int[] arrayToMatch) {
        if (Arrays.equals(arrayToMatch, RegValues.dash)) {
            return '-';
        } else if (Arrays.equals(arrayToMatch, RegValues.zero)) {
            return '0';
        } else if (Arrays.equals(arrayToMatch, RegValues.one)) {
            return '1';
        } else if (Arrays.equals(arrayToMatch, RegValues.two)) {
            return '2';
        } else if (Arrays.equals(arrayToMatch, RegValues.three)) {
            return '3';
        } else if (Arrays.equals(arrayToMatch, RegValues.four)) {
            return '4';
        } else if (Arrays.equals(arrayToMatch, RegValues.five)) {
            return '5';
        } else if (Arrays.equals(arrayToMatch, RegValues.six)) {
            return '6';
        } else if (Arrays.equals(arrayToMatch, RegValues.seven)) {
            return '7';
        } else if (Arrays.equals(arrayToMatch, RegValues.eight)) {
            return '8';
        } else if (Arrays.equals(arrayToMatch, RegValues.nine)) {
            return '9';
        } else if (Arrays.equals(arrayToMatch, RegValues.a)) {
            return 'a';
        } else if (Arrays.equals(arrayToMatch, RegValues.Acap)) {
            return 'A';
        } else if (Arrays.equals(arrayToMatch, RegValues.b)) {
            return 'b';
        } else if (Arrays.equals(arrayToMatch, RegValues.Bcap)) {
            return 'B';
        } else if (Arrays.equals(arrayToMatch, RegValues.c)) {
            return 'c';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ccap)) {
            return 'C';
        } else if (Arrays.equals(arrayToMatch, RegValues.d)) {
            return 'd';
        } else if (Arrays.equals(arrayToMatch, RegValues.Dcap)) {
            return 'D';
        } else if (Arrays.equals(arrayToMatch, RegValues.e)) {
            return 'e';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ecap)) {
            return 'E';
        } else if (Arrays.equals(arrayToMatch, RegValues.f)) {
            return 'f';
        } else if (Arrays.equals(arrayToMatch, RegValues.Fcap)) {
            return 'F';
        } else if (Arrays.equals(arrayToMatch, RegValues.forwardSlash)) {
            return '/';
        } else if (Arrays.equals(arrayToMatch, RegValues.g)) {
            return 'g';
        } else if (Arrays.equals(arrayToMatch, RegValues.Gcap)) {
            return 'G';
        } else if (Arrays.equals(arrayToMatch, RegValues.h)) {
            return 'h';
        } else if (Arrays.equals(arrayToMatch, RegValues.Hcap)) {
            return 'H';
        } else if (Arrays.equals(arrayToMatch, RegValues.i)) {
            return 'i';
        } else if (Arrays.equals(arrayToMatch, RegValues.Icap)) {
            return 'I';
        } else if (Arrays.equals(arrayToMatch, RegValues.J)) {
            return 'j';
        } else if (Arrays.equals(arrayToMatch, RegValues.Jcap)) {
            return 'J';
        } else if (Arrays.equals(arrayToMatch, RegValues.k)) {
            return 'k';
        } else if (Arrays.equals(arrayToMatch, RegValues.Kcap)) {
            return 'K';
        } else if (Arrays.equals(arrayToMatch, RegValues.l)) {
            return 'l';
        } else if (Arrays.equals(arrayToMatch, RegValues.Lcap)) {
            return 'L';
        } else if (Arrays.equals(arrayToMatch, RegValues.m)) {
            return 'm';
        } else if (Arrays.equals(arrayToMatch, RegValues.Mcap)) {
            return 'M';
        } else if (Arrays.equals(arrayToMatch, RegValues.n)) {
            return 'n';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ncap)) {
            return 'N';
        } else if (Arrays.equals(arrayToMatch, RegValues.o)) {
            return 'o';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ocap)) {
            return 'O';
        } else if (Arrays.equals(arrayToMatch, RegValues.p)) {
            return 'p';
        } else if (Arrays.equals(arrayToMatch, RegValues.Pcap)) {
            return 'P';
        } else if (Arrays.equals(arrayToMatch, RegValues.q)) {
            return 'q';
        } else if (Arrays.equals(arrayToMatch, RegValues.Qcap)) {
            return 'Q';
        } else if (Arrays.equals(arrayToMatch, RegValues.r)) {
            return 'r';
        } else if (Arrays.equals(arrayToMatch, RegValues.Rcap)) {
            return 'R';
        } else if (Arrays.equals(arrayToMatch, RegValues.s)) {
            return 's';
        } else if (Arrays.equals(arrayToMatch, RegValues.Scap)) {
            return 'S';
        } else if (Arrays.equals(arrayToMatch, RegValues.t)) {
            return 't';
        } else if (Arrays.equals(arrayToMatch, RegValues.Tcap)) {
            return 'T';
        } else if (Arrays.equals(arrayToMatch, RegValues.u)) {
            return 'u';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ucap)) {
            return 'U';
        } else if (Arrays.equals(arrayToMatch, RegValues.v)) {
            return 'v';
        } else if (Arrays.equals(arrayToMatch, RegValues.Vcap)) {
            return 'V';
        } else if (Arrays.equals(arrayToMatch, RegValues.W)) {
            return 'w';
        } else if (Arrays.equals(arrayToMatch, RegValues.Wcap)) {
            return 'W';
        } else if (Arrays.equals(arrayToMatch, RegValues.x)) {
            return 'x';
        } else if (Arrays.equals(arrayToMatch, RegValues.y)) {
            return 'y';
        } else if (Arrays.equals(arrayToMatch, RegValues.Ycap)) {
            return 'Y';
        } else if (Arrays.equals(arrayToMatch, RegValues.z)) {
            return 'z';
        } else if (Arrays.equals(arrayToMatch, RegValues.Zcap)) {
            return 'Z';
        } else if (Arrays.equals(arrayToMatch, RegValues.underScore)) {
            return '_';
        } else {
            //IllegalArgumentException ex = new IllegalArgumentException("Unknown Char");
            //throw ex;
            return '~';
        }
    }
}
