/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.idolutils.processors;

import com.autonomy.aci.client.services.Processor;
import com.autonomy.aci.client.transport.AciResponseInputStream;
import com.hp.autonomy.idolutils.IdolXmlMarshaller;

/**
 * Generic processor for handling Idol responses.
 * Note that this uses DOM processing behind the scenes so should not be used for very large responses.
 */
@SuppressWarnings("WeakerAccess")
public class AciResponseJaxbProcessor<T> implements Processor<T> {
    private static final long serialVersionUID = -1983490659468698548L;

    private final IdolXmlMarshaller idolXmlMarshaller;
    private final Class<T> responseDataType;

    public AciResponseJaxbProcessor(final IdolXmlMarshaller idolXmlMarshaller, final Class<T> responseDataType) {
        this.idolXmlMarshaller = idolXmlMarshaller;
        this.responseDataType = responseDataType;
    }

    @Override
    public T process(final AciResponseInputStream aciResponseInputStream) {
        return idolXmlMarshaller.parseIdolResponseData(aciResponseInputStream, responseDataType);
    }
}
