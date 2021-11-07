package com.kenshine.flowable.entity;

import lombok.Data;
import org.flowable.ui.modeler.model.ModelRepresentation;

/**
 * ModelRepresentationVo
 * @author: kenshine
 * @create: 2020-01-03 13:55
 **/
@Data
public class ModelRepresentationVo extends ModelRepresentation {

    private Boolean isDeployment = false;

    public ModelRepresentationVo() {}

    public ModelRepresentationVo(ModelRepresentation modelRepresentation) {
        id = modelRepresentation.getId();
        key = modelRepresentation.getKey();
        description = modelRepresentation.getDescription();
        name = modelRepresentation.getName();
        tenantId = modelRepresentation.getTenantId();
        version = modelRepresentation.getVersion();
        comment = modelRepresentation.getComment();
        createdBy = modelRepresentation.getCreatedBy();
        lastUpdated = modelRepresentation.getLastUpdated();
        lastUpdatedBy = modelRepresentation.getLastUpdatedBy();
        modelType = modelRepresentation.getModelType();
    }

    public ModelRepresentationVo(ModelRepresentation modelRepresentation, Boolean isDeployment) {
        id = modelRepresentation.getId();
        key = modelRepresentation.getKey();
        description = modelRepresentation.getDescription();
        name = modelRepresentation.getName();
        tenantId = modelRepresentation.getTenantId();
        version = modelRepresentation.getVersion();
        comment = modelRepresentation.getComment();
        createdBy = modelRepresentation.getCreatedBy();
        lastUpdated = modelRepresentation.getLastUpdated();
        lastUpdatedBy = modelRepresentation.getLastUpdatedBy();
        modelType = modelRepresentation.getModelType();
        this.isDeployment = isDeployment;
    }

}
