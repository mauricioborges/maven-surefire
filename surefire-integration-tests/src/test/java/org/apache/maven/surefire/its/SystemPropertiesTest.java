package org.apache.maven.surefire.its;


import junit.framework.TestCase;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

import java.io.File;
import java.util.ArrayList;

/**
 * Test system properties
 * 
 * @author <a href="mailto:dfabulich@apache.org">Dan Fabulich</a>
 * 
 */
public class SystemPropertiesTest
    extends TestCase
{
    public void testSystemProperties ()
        throws Exception
    {
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/system-properties" );

        Verifier verifier = new Verifier( testDir.getAbsolutePath() );
        ArrayList goals = new ArrayList();
        goals.add( "test" );
        goals.add( "-Dbaz=baz" );
        verifier.executeGoals( goals );
        verifier.verifyErrorFreeLog();
        verifier.resetStreams();
        
        HelperAssertions.assertTestSuiteResults( 3, 0, 0, 0, testDir );        
    }
}