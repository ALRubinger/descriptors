/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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
package org.jboss.shrinkwrap.descriptor.impl.base.query;

import java.util.List;

import org.jboss.shrinkwrap.descriptor.api.Node;
import org.jboss.shrinkwrap.descriptor.api.query.Query;

/**
 * GetSingleExpression
 *
 * @author <a href="mailto:aslak@redhat.com">Aslak Knutsen</a>
 * @version $Revision: $
 */
public class GetSingleQuery extends AbstractQueryExecuter<Node>
{

   /**
    * @param isAbsolute
    * @param paths
    */
   public GetSingleQuery(Query def)
   {
      super(def);
   }

   /* (non-Javadoc)
    * @see org.jboss.shrinkwrap.descriptor.api.Expression#execute(org.jboss.shrinkwrap.descriptor.api.Node)
    */
   @Override
   public Node execute(Node node)
   {
      GetQuery getAll = new GetQuery(getDefinition());
      List<Node> nodes = getAll.execute(node);
      
      if(nodes == null || nodes.size() == 0)
      {
         return null;
      }
      if(nodes.size() > 1)
      {
         throw new IllegalArgumentException("Multiple nodes matching expression found");
      }
      return nodes.get(0);
   }

}