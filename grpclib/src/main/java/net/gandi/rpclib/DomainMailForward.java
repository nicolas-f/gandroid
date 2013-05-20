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

import java.util.Arrays;
import java.util.Map;

/**
 * Mail aliases of a domain.
 * @author Nicolas Fortin
 */
public class DomainMailForward {
    private String source = "";
    private String[] destinations;

    /**
     * Value constructor.
     * @param source Alias mail address (without @mydomain.ext)
     * @param destinations Full mail address
     */
    public DomainMailForward(String source, String[] destinations) {
        this.source = source;
        this.destinations = destinations;
    }

    /**
     * @param object Request value
     */
    public DomainMailForward(Object object) {
        Map<String,Object> infos = (Map<String,Object>)object;
        source = infos.get("source").toString();
        Object[] destObj = (Object[]) infos.get("destinations");
        destinations = Arrays.copyOf(destObj,destObj.length,String[].class);
    }

    /**
     * @return Alias mail address (without @mydomain.ext)
     */
    public String getSource() {
        return source;
    }

    /**
     * @return Array of destination mail
     */
    public String[] getDestinations() {
        return destinations;
    }

    /**
     * @param source Alias mail address (without @mydomain.ext)
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @param destinations Full mail address
     */
    public void setDestinations(String[] destinations) {
        this.destinations = destinations;
    }
}
