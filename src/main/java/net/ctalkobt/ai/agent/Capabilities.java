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

import java.time.LocalDateTime;
import java.util.Collection;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * An enumeration of capabilities that are supported by the agent. A capability
 * is defined as a transformation between an incoming and outgoing mime type.
 * @see Capability
 */
public class Capabilities {
    private final int chargedCost;
    private final int time;
    private final int resourceConstraints; 
    private final Collection<Capability> capability;

    /**
     * Builder for {@link Capabilities}
     */
    public static class Builder {

        private int time;
        private int chargedCost;
        private int resourceConstraints;
        private Collection<Capability> capability;
                
        /**
         * Returns a {@link Capabilities} object based upon this builder.
         * 
         * @return
         */
        public Capabilities build()
        {
            return new Capabilities(this);
        }
        
        /**
         * Cost of retrieving a successful response from this Agent. Cost is
         * represented as an int w/ 2 implied decimal places.  1234 would equal
         * 12.34.  
         * <p>
         * <em>Note:</em> THe denominational unit is currently not defined. 
         * 
         * @param cost
         * @return
         */
        public Builder chargedCost(int cost)
        {
            this.chargedCost = cost;
            return this;
        }

        /**
         * Average time that a request is expected to take. 
         * 
         * @param time
         * @return
         */
        public Builder time(int time)
        {
            this.time = time;
            return this;
        }
        
        /**
         * How constrainted the Agent is to perform the request. Represented
         * int, this value corresponds to a percentage based - where 
         * 100 is the maximum constraint and indicates an agent willing to accept
         * requests but may take extra time in evaluating and returning a response.
         * 
         * @param constraints
         * @return
         */
        public Builder resourceConstraints(int constraints)
        {
            this.resourceConstraints = constraints;
            return this;
        }
        
        /**
         * A list of {@link Capability}'s that can be handled by the Agent. 
         * 
         * @param capabilities
         * @return
         */
        public Builder capability(Collection<Capability> capabilities)
        {
            this.capability = capabilities;
            return this;
        }                
        
    }

    @SuppressWarnings("AccessingNonPublicFieldOfAnotherObject")
    private Capabilities(Builder builder) {
        this.chargedCost = builder.chargedCost;
        this.time = builder.time;
        this.resourceConstraints = builder.resourceConstraints;
        this.capability = builder.capability;                
    }   
    
    /**
     * Cost for a request to be invoked.  Note that the value returned is 
     * understood to be have an implicit 4 digit place so all values should
     * be divided by 10000 to get the actual cost. 
     * 
     * Eg: 400 would equate to .4 in the cost unit being used. 
     * @return 
     */
    public Integer getChargedCost() {
        return chargedCost;
    }

    /**
     * @see net.ctalkobt.ai.agent.Capabilities.Builder#time(int) 
     * @return
     */
    public Integer getTime() {
        return time;
    }

    /**
     * @see net.ctalkobt.ai.agent.Capabilities.Builder#resourceConstraints(int)  
     * @return
     */
    public Integer getResourceConstraints() {
        return resourceConstraints;
    }

    /**
     * @see net.ctalkobt.ai.agent.Capabilities.Builder#capability(java.util.Collection)   
     * @return
     */
    public Collection<Capability> getCapability() {
        return capability;
    }

    /**
     * @return the current date and time.
     */
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
    
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("capability", this.capability)
                .append("resourceConstraints", this.resourceConstraints)
                .append("chargedCost", chargedCost)
                .append("time", time)
                .build();
    }
}
