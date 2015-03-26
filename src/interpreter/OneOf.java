/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Michał
 */
public class OneOf extends Interpreter implements Interface {
    
    List<Object> oneOf = new ArrayList<>();
    
    /**
     *
     * @param oneOf
     */
    public OneOf(Object... oneOf)
    {
        this.oneOf.addAll(Arrays.asList(oneOf));
    }

    @Override
    public boolean interpret() {
        for(Object of : oneOf)
        {
            if(of instanceof Match)
            {
                if(((Match)(of)).interpret())
                {
                    return true;
                }
            }
            else return false;
        }
        return false;
    }
    
}
