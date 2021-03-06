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
package net.ctalkobt.ai.agent.simple.constant;

import java.util.Arrays;
import java.util.Map;
import net.ctalkobt.ai.agent.Agent;
import net.ctalkobt.ai.agent.Capabilities;
import net.ctalkobt.ai.agent.Capability;
import net.ctalkobt.ai.agent.MimeType;
import net.ctalkobt.ai.agent.request.StringRequest;
import net.ctalkobt.ai.agent.response.NumericResponse;

/**
 *
 */
public class ConstantAgent implements Agent<NumericResponse, StringRequest> {

    /**
     *
     * @return
     */
    @Override
    public Capabilities info() {
        return new Capabilities.Builder()
            .chargedCost(1)
            .time(2)
            .capability(Arrays.asList(
                new Capability("constantOp", new MimeType("text", "math"), new MimeType("text", "value")),
                new Capability("constantOp", new MimeType("text", "math"), new MimeType("text", "ascii"))
            ))
            .build();
    }

    @Override
    public NumericResponse request(StringRequest body, Map<String, Object> headers) {
        switch(body.getData())
        {
            case "pi":
                return new NumericResponse(Math.PI, null);
            case "e":
                return new NumericResponse(Math.E, null);
            default:
                return null;    
        }
    }

}
