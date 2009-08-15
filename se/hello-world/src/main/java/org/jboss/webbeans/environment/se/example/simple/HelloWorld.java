/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.webbeans.environment.se.example.simple;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Current;
import javax.enterprise.inject.spi.AfterDeploymentValidation;

/**
 * @author Peter Royle
 */
public class HelloWorld
{

    @Current
    CommandLineArgsValidator argsVlidator;

    /**
     * Prints a hello message using the first name.
     * @param firstName The first name.
     */
    public void printHello( @Observes
            AfterDeploymentValidation after )
    {
        if (!argsVlidator.hasErrors())
        {
            System.out.println( "Hello " + argsVlidator.getValidParameters().get( 0 ) );
        } else
        {
            System.out.println( "Please provide just one argument: your first name" );
        }
    }
}
