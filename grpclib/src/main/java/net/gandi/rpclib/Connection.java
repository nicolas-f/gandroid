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

import de.timroes.axmlrpc.XMLRPCClient;
import de.timroes.axmlrpc.XMLRPCException;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.*;

/**
 * Hold information to send request to the remote API.
 * @author Nicolas Fortin
 */
public class Connection {
    private final XMLRPCClient rpc;
    private final String apikey;
    private static final String PRODUCTION_API_URL = "https://rpc.gandi.net/xmlrpc/";
    private static final String TEST_API_URL = "https://rpc.ote.gandi.net/xmlrpc/";

    /**
     * Constructor using default URL.
     * @param test If true this connection will use RPC OTE api url.
     * @param apikey
     */
    public Connection(boolean test,String apikey) throws GeneralSecurityException, IOException {
        this.apikey = apikey;
        if(test) {
            rpc = new XMLRPCClient(new URL(TEST_API_URL));
        } else {
            rpc = new XMLRPCClient(new URL(PRODUCTION_API_URL));
        }
    }

    /**
     * Call method using apikey as first parameter
     * @param method Method(s) name
     * @param params Parameters, without apikey
     * @return Result object
     */
    public Object call(String method,Object... params) throws IOException {
        try {
            if(params.length!=0) {
                Object[] newParams = new Object[params.length+1];
                System.arraycopy(params,0,newParams,1,params.length);
                newParams[0] = apikey;
                return rpc.call(method, apikey,  newParams);
            } else {
                return rpc.call(method,apikey);
            }
        }catch (XMLRPCException ex) {
            throw new IOException(ex);
        }
    }
}
