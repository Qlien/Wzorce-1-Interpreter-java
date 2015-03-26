/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import static interpreter.Interpreter.pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Michał
 */
public class Sequence extends Interpreter implements Interface {

    List<Object> oneOf = new ArrayList<>();
    String insidePattern = ".*";

    /**
     *
     * @param oneOf
     */
    public Sequence(Object... oneOf) {
        this.oneOf.addAll(Arrays.asList(oneOf));
    }

    @Override
    public boolean interpret() {

        boolean lastOneOf = false;

        for (Object of : oneOf) 
        {
            if (of instanceof Match) {
                if (lastOneOf) {
                    insidePattern = insidePattern.substring(0, insidePattern.length()-1);
                    insidePattern += ")";
                    lastOneOf = false;
                }
                insidePattern += ((Match) (of)).s;
            } else if (of instanceof OneOf) {
                if (!lastOneOf) {
                    lastOneOf = true;
                    insidePattern += "(";
                }
                for (Object ob : ((OneOf) (of)).oneOf) {
                    if (ob instanceof Match) {
                        insidePattern += ((Match) (ob)).s+"|";
                    } else {
                        return false;
                    }
                }
            }
        }
        if (lastOneOf) {
            insidePattern = insidePattern.substring(0, insidePattern.length()-1);
            insidePattern += ")";
            lastOneOf = false;
        }
        insidePattern += ".*";
        if (pattern.matches(insidePattern)) {
            return true;
        } else {
            return false;
        }
    }
}
