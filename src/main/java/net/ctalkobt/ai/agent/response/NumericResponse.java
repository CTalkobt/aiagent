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
package net.ctalkobt.ai.agent.response;

import java.util.Map;

/**
 * Returns a numeric Response type. 
 * 
 * @see Response
 */
public class NumericResponse implements Response<Number> {

    private final Number body;
    private final Map<String, Object> headers;

    /**
     * 
     * @param body
     * @param headers
     */
    public NumericResponse(Number body, Map<String,Object> headers) {
        this.headers = headers;
        this.body = body;
    }
    
    @Override
    public Number getBody() {
        return this.body;
    }

    /**
     * Return additional headers associated with the response.
     * @return
     */
    @Override
    public Map<String, Object> getHeaders() {
        return headers;
    }
    
}
