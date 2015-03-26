/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

/**
 *
 * @author Michał
 */
public class Interpreter {

    public static String pattern = "axc";
    
    public static void main(String[] args) {
        Match ma = new Match("a");
        Match mb = new Match("b");
        Match mx = new Match("x");
        Match mc = new Match("c");
        System.out.println(ma.interpret());
        OneOf of = new OneOf(mb, mx);
        System.out.println(of.interpret());
        Sequence seq1 = new Sequence(ma, of); // true
        Sequence seq2 = new Sequence(of, ma); // false
        System.out.println(seq1.interpret() + " " + seq2.interpret());
    }
    
}
