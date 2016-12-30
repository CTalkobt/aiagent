/*
 * Copyright (C) 2016 Craig Taylor <ctalkobt@ctalkoobt.net>duck
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.ctalkobt.ai.agent.simple.math;

import java.util.Arrays;
import java.util.Map;
import net.ctalkobt.ai.agent.Agent;
import net.ctalkobt.ai.agent.Capabilities;
import net.ctalkobt.ai.agent.Capability;
import net.ctalkobt.ai.agent.response.NumericResponse;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

/**
 *
 */
public class MathAgent implements Agent<String, NumericResponse> {
    private static final JexlEngine JEXLEngine = new JexlBuilder().cache(128).strict(true).silent(false).create();
    
    @Override
    public Capabilities info() {
        return new Capabilities.Builder()
            .chargedCost(1)
            .time(100)
            .capability(Arrays.asList( new Capability[] {
                new Capability("mathOp", "text/ascii/math", "text/ascii/value")                                            
            } ))
            .build();
    }

    @Override
    public NumericResponse request(String body, Map<String, String> headers) {
        JexlContext context = new MapContext();
        JexlExpression e = JEXLEngine.createExpression( body );
        Object result = e.evaluate(context);
        return new NumericResponse((Number) result, null);
    }

}
