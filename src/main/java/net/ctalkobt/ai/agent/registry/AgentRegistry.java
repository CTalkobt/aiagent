/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
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

package net.ctalkobt.ai.agent.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.ctalkobt.ai.agent.Agent;
import net.ctalkobt.ai.agent.request.Request;
import net.ctalkobt.ai.agent.response.Response;

/**
 *
 */
public class AgentRegistry {
    private final List<Agent> agents = new ArrayList<>();
    
    public AgentRegistry() {
        
    }
    
    public void register(Agent agent) { 
        agents.add(agent);
    }
    
    public <T,S> Response<T> dispatch(Request request, Map<String,Object> headers) {
        List<Agent> agentsSupportingRequest = agents.stream()
                .filter(ag -> ag.supports(request))
                .collect(Collectors.toList());
        List<Response<T>> responses = agentsSupportingRequest.stream()
                .collect(ag -> ag.)
    }
}
