package cz.zcu.validator.jdparser;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import cz.zcu.validator.jdparser.api.JsoupJavaDocParser;
import cz.zcu.validator.jdparser.data.JavaDocParsingException;

/**
 * Unit test for simple App.
 */
public class JDParserTest {

    @Test
    public void standardJavaDocDocumentsTest() {

    	String base_url = "http://cogcomp.cs.illinois.edu/software/doc/apidocs/edu/illinois/cs/cogcomp/edison/features/"; //This URL will be expected to the base URL of the public repository. We will extract the testcode to be presented on the web interface from here.
    	
        String repository_path = "/lrec/"; //We will be using string to check for Classes whose path contains this substring. 
	
	//Raw Github URL base for Tests
	String github_url_base_raw = "https://raw.githubusercontent.com/IllinoisCogComp/illinois-cogcomp-nlp/master/edison/src/test/java/edu/illinois/cs/cogcomp/edison/features/lrec/";
	
	String path_to_write_json = "../data.json";

    	JsoupJavaDocParser parser = new JsoupJavaDocParser(base_url, repository_path, github_url_base_raw, path_to_write_json);

        try {
        	// parses javadoc directory of the Edison project
            parser.parseDataFromJavaDoc(new File("src/test/apidoc/software/doc/illinois-edison/apidocs"));
            
        } catch (JavaDocParsingException e) {

            fail(e.getMessage());
        }

    }
}
