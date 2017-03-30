/*
 * Copyright 2001-2004 (C) MetaStuff, Ltd. All Rights Reserved.
 * 
 * This software is open source. 
 * See the bottom of this file for the licence.
 * 
 * $Id: CountDemo.java,v 1.4 2005/01/29 14:52:57 maartenc Exp $
 */

package org.dom4j.samples;

import org.dom4j.Attribute;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;
import org.dom4j.Visitor;
import org.dom4j.VisitorSupport;

/**
 * A sample program to count the number of various kinds of DOM4J node types
 * 
 * @author <a href="mailto:james.strachan@metastuff.com">James Strachan </a>
 * @version $Revision: 1.4 $
 */
public class CountDemo extends SAXDemo {

    private int numCharacters;

    private int numComments;

    private int numElements;

    private int numAttributes;

    private int numProcessingInstructions;

    public static void main(String[] args) {
        run(new CountDemo(), args);
    }

    public CountDemo() {
    }

    protected void process(Document document) throws Exception {
        numCharacters = 0;
        numComments = 0;
        numElements = 0;
        numAttributes = 0;
        numProcessingInstructions = 0;

        Visitor visitor = new VisitorSupport() {

            public void visit(Element node) {
                ++numElements;
            }

            public void visit(Attribute node) {
                ++numAttributes;
            }

            public void visit(Comment node) {
                ++numComments;
            }

            public void visit(ProcessingInstruction node) {
                ++numProcessingInstructions;
            }

            public void visit(Text node) {
                String text = node.getText();
                if (text != null) {
                    numCharacters += text.length();
                }
            }
        };

        println("Document: " + document.getName() + " has the following");
        println("Elements\tAttributes\tComments\tPIs\tCharacters");

        document.accept(visitor);

        println(numElements + "\t\t" + numAttributes + "\t\t" + numComments
                + "\t\t" + numProcessingInstructions + "\t" + numCharacters);
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
 * Copyright 2001-2004 (C) MetaStuff, Ltd. All Rights Reserved.
 * 
 * $Id: CountDemo.java,v 1.4 2005/01/29 14:52:57 maartenc Exp $
 */
