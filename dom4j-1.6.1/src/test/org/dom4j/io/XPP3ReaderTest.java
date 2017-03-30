/*
 * Copyright 2001-2005 (C) MetaStuff, Ltd. All Rights Reserved.
 *
 * This software is open source.
 * See the bottom of this file for the licence.
 */

package org.dom4j.io;

import junit.textui.TestRunner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;

import org.dom4j.AbstractTestCase;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Test class for the XPP3Reader. This is based on the TestSaxReader class.
 * 
 * @author <a href="mailto:pelle@neubia.com">Pelle Braendgaard </a>
 * @author <a href="mailto:maartenc@sourceforge.net">Maarten Coene </a>
 */
public class XPP3ReaderTest extends AbstractTestCase {
    public static void main(String[] args) {
        TestRunner.run(XPP3ReaderTest.class);
    }

    // Test case(s)
    // -------------------------------------------------------------------------
    public void testRussian() throws Exception {
        File file = getFile("/xml/russArticle.xml");
        XPP3Reader xmlReader = new XPP3Reader();
        Document doc = xmlReader.read(file);
        Element el = doc.getRootElement();

        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer);
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("koi8-r");
        xmlWriter.write(doc);
        log(writer.toString());
    }

    public void testRussian2() throws Exception {
        File file = getFile("/xml/russArticle.xml");
        XPP3Reader xmlReader = new XPP3Reader();
        Document doc = xmlReader.read(file);
        XMLWriter xmlWriter = new XMLWriter(new OutputFormat("", false,
                "koi8-r"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        xmlWriter.setOutputStream(out);
        xmlWriter.write(doc);
        xmlWriter.flush();
        xmlWriter.close();
        log(out.toString());
    }
}

/*
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided that the
 * following conditions are met:
 * 
 * 1. Redistributions of source code must retain copyright statements and
 * notices. Redistributions must also contain a copy of this document.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * 
 * 3. The name "DOM4J" must not be used to endorse or promote products derived
 * from this Software without prior written permission of MetaStuff, Ltd. For
 * written permission, please contact dom4j-info@metastuff.com.
 * 
 * 4. Products derived from this Software may not be called "DOM4J" nor may
 * "DOM4J" appear in their names without prior written permission of MetaStuff,
 * Ltd. DOM4J is a registered trademark of MetaStuff, Ltd.
 * 
 * 5. Due credit should be given to the DOM4J Project - http://www.dom4j.org
 * 
 * THIS SOFTWARE IS PROVIDED BY METASTUFF, LTD. AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL METASTUFF, LTD. OR ITS CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * Copyright 2001-2005 (C) MetaStuff, Ltd. All Rights Reserved.
 */
