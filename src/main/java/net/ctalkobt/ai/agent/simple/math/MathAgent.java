/*
 * Copyright (C) 2016 Craig Taylor <ctalkobt@ctalkoobt.net>
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
import net.ctalkobt.ai.agent.MimeType;
import net.ctalkobt.ai.agent.request.Request;
import net.ctalkobt.ai.agent.response.NumericResponse;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

/**
 *
 */
public class MathAgent implements Agent<NumericResponse, Request<String>> {
    private final JexlEngine JEXLEngine = new JexlBuilder().cache(128).strict(true).silent(false).create();
    
    /**
     *
     * @return
     */
    @Override
    public Capabilities info() {
        return new Capabilities.Builder()
            .chargedCost(1)
            .time(100)
            .capability(Arrays.asList( new Capability[] {
                new Capability("mathOp", new MimeType("text", "math"), new MimeType("text", "value"))                                            
            }) )
            .build();
    }

    @Override
    public NumericResponse request(Request<String> body, Map<String, Object> headers) {
        JexlContext context = new MapContext();
        JexlExpression e = JEXLEngine.createExpression( body.getData() );
        Object result = e.evaluate(context);
        return new NumericResponse((Number) result, null);
    }

    @Override
    public NumericResponse request(Request<String> req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
