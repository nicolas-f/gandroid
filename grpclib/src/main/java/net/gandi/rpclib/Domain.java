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
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A domain owned by the user
 * @author Nicolas Fortin
 */
public class Domain {
    private final Connection connection;
    private final Map<String,Object> domainInfos;
    public static final String NAME_KEY = "fqdn";
    public static final String DATE_REGISTRY_END_KEY = "date_registry_end";

    public Domain(Connection connection, Object requestValue) {
        this.connection = connection;
        this.domainInfos = (Map<String,Object>)requestValue;
    }

    /**
     * @return Domain name ex: mydomain.com
     */
    public String getDomainName() {
        return domainInfos.get(NAME_KEY).toString();
    }

    /**
     * @return End of domain name contract.
     */
    public Date getDateRegistryEnd() {
        return (Date)domainInfos.get(DATE_REGISTRY_END_KEY);
    }

    /**
     * Get mail alias of this domain. This method open connection and may take time to respond.
     * @return Domain mail forwards list
     * @throws IOException
     */
    public List<DomainMailForward> getMailForwards() throws IOException {
        List<DomainMailForward> mailForwards = new LinkedList<DomainMailForward>();
        Object[] res = (Object[])connection.call("domain.forward.list",getDomainName());
        for(Object redir : res) {
            mailForwards.add(new DomainMailForward(redir));
        }
        return mailForwards;
    }
}
