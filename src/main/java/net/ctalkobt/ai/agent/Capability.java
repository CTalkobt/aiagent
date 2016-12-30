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

import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A capability is defined as an operationg performed on a specific mime type
 * resulting in the production of the same or different mime type. 
 * 
 * @see #getAcceptedMimeTypes() 
 * @see #getGeneratedMimeType() 
 */
public class Capability {
    private final Collection<String> acceptedMimeTypes;
    private final Collection<String> generatedMimeType;
    private final String name;

    public Capability(String name, 
            Collection<String> acceptedTypes, 
            Collection<String> generatedTypes)
    {
        assert name != null;
        assert acceptedTypes != null;
        assert generatedTypes != null;        
        
        this.acceptedMimeTypes = acceptedTypes;
        this.generatedMimeType = generatedTypes;
        this.name = name;
    }

    public Capability( String name, String acceptType, String generateType)
    {
        this.name = name;
        this.acceptedMimeTypes = Arrays.asList( new String[] { acceptType });
        this.generatedMimeType = Arrays.asList( new String[] { generateType });
    }
    
    public Collection<String> getAcceptedMimeTypes() {
        return acceptedMimeTypes;
    }

    public Collection<String> getGeneratedMimeType() {
        return generatedMimeType;
    }

    /**
     * This name is intended for <em>tracking purposes and <ul>should not</ul></em> be used for discrimination among different capabilitiy operations.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("generatedMimeType", generatedMimeType)
                .append("acceptedMimeType", acceptedMimeTypes)
                .build();
    }
    
    
}
