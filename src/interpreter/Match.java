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
public class Match extends Interpreter implements Interface {

    String s;
    
    public Match(String s)
    {
        this.s = s;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean interpret() {
        return pattern.contains(s);
    }
    
}
