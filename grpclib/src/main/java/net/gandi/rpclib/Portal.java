/*
 * Gandroid is an Android client for administrating Gandi services.
 *
 * Gandroid is distributed under GPL 3 license.
 *
 * Gandroid is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Gandroid is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Gandroid. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.github.com/binseeds/gandroid>
 */
package net.gandi.rpclib;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry point for Gandi API access.
 * @author Nicolas Fortin
 */
public class Portal {
    private final Connection connection;

    /**
     * Constructor
     * @param connection
     */
    public Portal(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return Domain list
     */
    public List<Domain> getDomains() throws IOException {
        List<Domain> domainList = new LinkedList<Domain>();
        Object[] nameservers = (Object[]) connection.call("domain.list");
        for(Object domainObj : nameservers) {
            domainList.add(new Domain(connection,domainObj.toString()));
        }
        return domainList;
    }
}
