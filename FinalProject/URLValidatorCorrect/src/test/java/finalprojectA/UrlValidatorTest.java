
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;

import java.util.Random;
import java.lang.*;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

    private boolean printStatus = false;
    private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

    public UrlValidatorTest(String testName) {
        super(testName);
    }



    public void testManualTest()
    {
        //ALLOW ALL SCHEMES - "allows the passing of any scheme with correct formatting"
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println(urlVal.isValid("http://www.amazon.com"));
        assertTrue(urlVal.isValid("https://www.amazon.com"));
        assertTrue(urlVal.isValid("http://www.amazon.com"));
        assertTrue(urlVal.isValid("ridiculousscheme999://www.amazon.com"));
        assertTrue(urlVal.isValid("kombucha://www.amazon.com"));
        assertFalse(urlVal.isValid("999://www.amazon.com")); //Integers are not correct format
        assertFalse(urlVal.isValid("://www.amazon.com"));
        assertFalse(urlVal.isValid(""));
        assertTrue(urlVal.isValid("https://1.190.0.40"));
        assertTrue(urlVal.isValid("https://255.255.255.255"));
        assertFalse(urlVal.isValid("https://-1.190.30.40"));
        assertFalse(urlVal.isValid("https://255.-25.255.255"));
        assertFalse(urlVal.isValid("https://256.256.256.256"));
        assertFalse(urlVal.isValid("https://900.255.255.255"));


    }


    public void testYourFirstPartition()
    {
        //Partition is based on tld arrays in DomainValidator.java
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertTrue(urlVal.isValid("https://www.amazon.arpa"));  //Infrastructure tld
        assertTrue(urlVal.isValid("https://www.amazon.aero"));  //Generic tld
        assertTrue(urlVal.isValid("https://www.amazon.ac"));    //Country Code tld
        assertFalse(urlVal.isValid("https://www.amazon.localhost")); //local tld
        UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.ALLOW_LOCAL_URLS);
        assertTrue(urlVal.isValid("https://www.amazon.arpa"));  //Infrastructure tld
        assertTrue(urlVal.isValid("https://www.amazon.aero"));  //Generic tld
        assertTrue(urlVal.isValid("https://www.amazon.ac"));    //Country Code tld
        assertTrue(urlVal2.isValid("https://www.amazon.localhost")); //local tld


    }


    public void testIsValid()
    {
        for(int i = 0;i<10000;i++){
            Random generator = new Random();
            UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
            String[] testUrlScheme = { "https://", "http://" } ;
            String[] testUrlAuthority = { "www.google.com", "0.0.0.0" } ;
            String[] testUrlPort = { ":8000", ":0" } ;
            String[] testUrlPath = { "/test1", "/file" } ;
            String[] testUrlQuery = {} ;
            int[] testPartsIndex = {0, 0, 0, 0, 0};
            StringBuffer testBuffer = new StringBuffer();
            int schemeRandIndex = generator.nextInt(testUrlScheme.length);
            testBuffer.append(testUrlScheme[schemeRandIndex]);
            int authorityRandIndex = generator.nextInt(testUrlAuthority.length);
            testBuffer.append(testUrlAuthority[authorityRandIndex]);
            int portRandIndex = generator.nextInt(testUrlPort.length);
            testBuffer.append(testUrlPort[portRandIndex]);
            int pathRandIndex = generator.nextInt(testUrlPath.length);
            testBuffer.append(testUrlPath[pathRandIndex]);
            //int queryRandIndex = generator.nextInt(testUrlQuery.length);
            //testBuffer.append(testUrlQuery[queryRandIndex]);
            String str = testBuffer.toString();
            System.out.println(schemeRandIndex);
            System.out.println(authorityRandIndex);
            System.out.println(portRandIndex);
            System.out.println(pathRandIndex);

            System.out.println(str);
            assertTrue(urlVal.isValid(str));
        }
    }

    public void testAnyOtherUnitTest()
    {

    }
    /**
     * Create set of tests by taking the testUrlXXX arrays and
     * running through all possible permutations of their combinations.
     *
     * @param testObjects Used to create a url.
     */


}
