package com.emop.mockapi;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.taodian.mockapi.ApiNameConvert;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main(String[] args) {
		/*TaodianApi api = new TaodianApi();
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("time", System.currentTimeMillis());
		api.call("short_url", params);*/
    	
    	ApiNameConvert anc = new ApiNameConvert();
		String pac = anc.getApiPackage("click_app_shortKey_list");
		String name = anc.formateApiName("click_app_shortKey_list");
		new com.taodian.mockapi.service.impl.ClickApiImpl();
		
		System.out.println(pac);
		System.out.println(name);
		
	}
}
