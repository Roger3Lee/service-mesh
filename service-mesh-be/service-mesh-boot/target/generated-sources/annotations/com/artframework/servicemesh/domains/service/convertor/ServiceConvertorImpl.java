package com.artframework.servicemesh.domains.service.convertor;

import com.artframework.servicemesh.domains.service.dto.ServiceDTO;
import com.artframework.servicemesh.domains.service.dto.ServiceDTO.SvcMeshDatasourceDTO;
import com.artframework.servicemesh.entities.SvcMeshDatasourceDO;
import com.artframework.servicemesh.entities.SvcMeshServiceDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T21:13:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class ServiceConvertorImpl implements ServiceConvertor {

    private final ServiceConvertorDecorator serviceConvertorDecorator = new ServiceConvertorDecorator();

    @Override
    public ServiceDTO convert2DTO(SvcMeshServiceDO request) {
        if ( request == null ) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setId( request.getId() );
        serviceDTO.setDatasourceId( request.getDatasourceId() );
        serviceDTO.setCode( request.getCode() );
        serviceDTO.setName( request.getName() );
        serviceDTO.setInputTemplate( request.getInputTemplate() );
        serviceDTO.setConfig( request.getConfig() );
        serviceDTO.setOutputTemplate( request.getOutputTemplate() );
        serviceDTO.setTenantId( request.getTenantId() );
        serviceDTO.setVersion( request.getVersion() );
        serviceDTO.setCreateBy( request.getCreateBy() );
        serviceDTO.setCreateByName( request.getCreateByName() );
        serviceDTO.setCreateTime( request.getCreateTime() );
        serviceDTO.setUpdateBy( request.getUpdateBy() );
        serviceDTO.setUpdateByName( request.getUpdateByName() );
        serviceDTO.setUpdateTime( request.getUpdateTime() );

        return serviceDTO;
    }

    @Override
    public List<ServiceDTO> convert2DTO(List<SvcMeshServiceDO> request) {
        if ( request == null ) {
            return null;
        }

        List<ServiceDTO> list = new ArrayList<ServiceDTO>( request.size() );
        for ( SvcMeshServiceDO svcMeshServiceDO : request ) {
            list.add( convert2DTO( svcMeshServiceDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshServiceDO convert2DO(ServiceDTO request) {
        serviceConvertorDecorator.before( request );

        if ( request == null ) {
            return null;
        }

        SvcMeshServiceDO svcMeshServiceDO = new SvcMeshServiceDO();

        svcMeshServiceDO.setId( request.getId() );
        svcMeshServiceDO.setDatasourceId( request.getDatasourceId() );
        svcMeshServiceDO.setCode( request.getCode() );
        svcMeshServiceDO.setName( request.getName() );
        svcMeshServiceDO.setInputTemplate( request.getInputTemplate() );
        svcMeshServiceDO.setConfig( request.getConfig() );
        svcMeshServiceDO.setOutputTemplate( request.getOutputTemplate() );
        svcMeshServiceDO.setTenantId( request.getTenantId() );
        svcMeshServiceDO.setVersion( request.getVersion() );
        svcMeshServiceDO.setCreateBy( request.getCreateBy() );
        svcMeshServiceDO.setCreateByName( request.getCreateByName() );
        svcMeshServiceDO.setCreateTime( request.getCreateTime() );
        svcMeshServiceDO.setUpdateBy( request.getUpdateBy() );
        svcMeshServiceDO.setUpdateByName( request.getUpdateByName() );
        svcMeshServiceDO.setUpdateTime( request.getUpdateTime() );

        serviceConvertorDecorator.after( request, svcMeshServiceDO );

        return svcMeshServiceDO;
    }

    @Override
    public List<SvcMeshServiceDO> convert2DO(List<ServiceDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshServiceDO> list = new ArrayList<SvcMeshServiceDO>( request.size() );
        for ( ServiceDTO serviceDTO : request ) {
            list.add( convert2DO( serviceDTO ) );
        }

        return list;
    }

    @Override
    public SvcMeshDatasourceDTO convert2SvcMeshDatasourceDTO(SvcMeshDatasourceDO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshDatasourceDTO svcMeshDatasourceDTO = new SvcMeshDatasourceDTO();

        svcMeshDatasourceDTO.setId( request.getId() );
        svcMeshDatasourceDTO.setCode( request.getCode() );
        svcMeshDatasourceDTO.setName( request.getName() );
        svcMeshDatasourceDTO.setType( request.getType() );
        svcMeshDatasourceDTO.setConfig( request.getConfig() );
        svcMeshDatasourceDTO.setTenantId( request.getTenantId() );
        svcMeshDatasourceDTO.setVersion( request.getVersion() );
        svcMeshDatasourceDTO.setCreateBy( request.getCreateBy() );
        svcMeshDatasourceDTO.setCreateByName( request.getCreateByName() );
        svcMeshDatasourceDTO.setCreateTime( request.getCreateTime() );
        svcMeshDatasourceDTO.setUpdateBy( request.getUpdateBy() );
        svcMeshDatasourceDTO.setUpdateByName( request.getUpdateByName() );
        svcMeshDatasourceDTO.setUpdateTime( request.getUpdateTime() );

        return svcMeshDatasourceDTO;
    }

    @Override
    public List<SvcMeshDatasourceDTO> convert2SvcMeshDatasourceDTO(List<SvcMeshDatasourceDO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshDatasourceDTO> list = new ArrayList<SvcMeshDatasourceDTO>( request.size() );
        for ( SvcMeshDatasourceDO svcMeshDatasourceDO : request ) {
            list.add( convert2SvcMeshDatasourceDTO( svcMeshDatasourceDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshDatasourceDO convert2SvcMeshDatasourceDO(SvcMeshDatasourceDTO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshDatasourceDO svcMeshDatasourceDO = new SvcMeshDatasourceDO();

        svcMeshDatasourceDO.setId( request.getId() );
        svcMeshDatasourceDO.setCode( request.getCode() );
        svcMeshDatasourceDO.setName( request.getName() );
        svcMeshDatasourceDO.setType( request.getType() );
        svcMeshDatasourceDO.setConfig( request.getConfig() );
        svcMeshDatasourceDO.setTenantId( request.getTenantId() );
        svcMeshDatasourceDO.setVersion( request.getVersion() );
        svcMeshDatasourceDO.setCreateBy( request.getCreateBy() );
        svcMeshDatasourceDO.setCreateByName( request.getCreateByName() );
        svcMeshDatasourceDO.setCreateTime( request.getCreateTime() );
        svcMeshDatasourceDO.setUpdateBy( request.getUpdateBy() );
        svcMeshDatasourceDO.setUpdateByName( request.getUpdateByName() );
        svcMeshDatasourceDO.setUpdateTime( request.getUpdateTime() );

        return svcMeshDatasourceDO;
    }

    @Override
    public List<SvcMeshDatasourceDO> convert2SvcMeshDatasourceDO(List<SvcMeshDatasourceDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshDatasourceDO> list = new ArrayList<SvcMeshDatasourceDO>( request.size() );
        for ( SvcMeshDatasourceDTO svcMeshDatasourceDTO : request ) {
            list.add( convert2SvcMeshDatasourceDO( svcMeshDatasourceDTO ) );
        }

        return list;
    }
}
