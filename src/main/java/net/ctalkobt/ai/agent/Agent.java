/*
* Copyright (C) 2016 Craig Taylor <ctalkobt@ctalkobt.net>
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
package net.ctalkobt.ai.agent;

import java.util.HashMap;
import net.ctalkobt.ai.agent.response.Response;
import java.util.Map;
import net.ctalkobt.ai.agent.request.Request;

/**
 * Defines the responsibilities of an Agent that is able to process 
 * and handle incoming requests and responses. 
 * 
 * @param <S> Incoming request bosy type.
 * @param <R> Extended from {@link Response}, defines the response to the request.
 * 
 * @see Response
 */
public interface Agent<S,R extends Response> {

    /**
     * Defines the capabilities / operations that the Agent is capable of operating on.
     * 
     * @return
     */
    Capabilities info(); 
    
    default boolean supports(Request<S> req) { return true; }
    
    default R request(Request<S> req) { 
        Map<String, Object> headers = new HashMap<>(); 
        headers.put("mimeType", req.getMimeType());
        return request(req.getData(), headers); 
    }
    
    /**
     * Handles a given request. 
     * 
     * @param body
     * @param headers Optional header mappings containing additional information
     *   potentially necessary outside that of the body . 
     * @return
     */
    R request(S body, Map<String,Object> headers);
}
