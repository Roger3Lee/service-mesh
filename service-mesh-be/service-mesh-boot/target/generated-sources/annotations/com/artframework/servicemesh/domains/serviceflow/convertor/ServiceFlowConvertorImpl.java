package com.artframework.servicemesh.domains.serviceflow.convertor;

import com.artframework.servicemesh.domains.serviceflow.dto.ServiceFlowDTO;
import com.artframework.servicemesh.domains.serviceflow.dto.ServiceFlowDTO.SvcMeshFlowConfigDTO;
import com.artframework.servicemesh.domains.serviceflow.dto.ServiceFlowDTO.SvcMeshFlowInvokeLogDTO;
import com.artframework.servicemesh.domains.serviceflow.dto.ServiceFlowDTO.SvcMeshFlowNodeDTO;
import com.artframework.servicemesh.entities.SvcMeshFlowConfigDO;
import com.artframework.servicemesh.entities.SvcMeshFlowDO;
import com.artframework.servicemesh.entities.SvcMeshFlowInvokeLogDO;
import com.artframework.servicemesh.entities.SvcMeshFlowNodeDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T21:13:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class ServiceFlowConvertorImpl implements ServiceFlowConvertor {

    private final ServiceFlowConvertorDecorator serviceFlowConvertorDecorator = new ServiceFlowConvertorDecorator();

    @Override
    public ServiceFlowDTO convert2DTO(SvcMeshFlowDO request) {
        if ( request == null ) {
            return null;
        }

        ServiceFlowDTO serviceFlowDTO = new ServiceFlowDTO();

        serviceFlowDTO.setId( request.getId() );
        serviceFlowDTO.setUuid( request.getUuid() );
        serviceFlowDTO.setCode( request.getCode() );
        serviceFlowDTO.setName( request.getName() );
        serviceFlowDTO.setDescription( request.getDescription() );
        serviceFlowDTO.setTenantId( request.getTenantId() );
        serviceFlowDTO.setVersion( request.getVersion() );
        serviceFlowDTO.setCreateBy( request.getCreateBy() );
        serviceFlowDTO.setCreateByName( request.getCreateByName() );
        serviceFlowDTO.setCreateTime( request.getCreateTime() );
        serviceFlowDTO.setUpdateBy( request.getUpdateBy() );
        serviceFlowDTO.setUpdateByName( request.getUpdateByName() );
        serviceFlowDTO.setUpdateTime( request.getUpdateTime() );

        return serviceFlowDTO;
    }

    @Override
    public List<ServiceFlowDTO> convert2DTO(List<SvcMeshFlowDO> request) {
        if ( request == null ) {
            return null;
        }

        List<ServiceFlowDTO> list = new ArrayList<ServiceFlowDTO>( request.size() );
        for ( SvcMeshFlowDO svcMeshFlowDO : request ) {
            list.add( convert2DTO( svcMeshFlowDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowDO convert2DO(ServiceFlowDTO request) {
        serviceFlowConvertorDecorator.before( request );

        if ( request == null ) {
            return null;
        }

        SvcMeshFlowDO svcMeshFlowDO = new SvcMeshFlowDO();

        svcMeshFlowDO.setId( request.getId() );
        svcMeshFlowDO.setUuid( request.getUuid() );
        svcMeshFlowDO.setCode( request.getCode() );
        svcMeshFlowDO.setName( request.getName() );
        svcMeshFlowDO.setDescription( request.getDescription() );
        svcMeshFlowDO.setTenantId( request.getTenantId() );
        svcMeshFlowDO.setVersion( request.getVersion() );
        svcMeshFlowDO.setCreateBy( request.getCreateBy() );
        svcMeshFlowDO.setCreateByName( request.getCreateByName() );
        svcMeshFlowDO.setCreateTime( request.getCreateTime() );
        svcMeshFlowDO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowDO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowDO.setUpdateTime( request.getUpdateTime() );

        serviceFlowConvertorDecorator.after( request, svcMeshFlowDO );

        return svcMeshFlowDO;
    }

    @Override
    public List<SvcMeshFlowDO> convert2DO(List<ServiceFlowDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowDO> list = new ArrayList<SvcMeshFlowDO>( request.size() );
        for ( ServiceFlowDTO serviceFlowDTO : request ) {
            list.add( convert2DO( serviceFlowDTO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowConfigDTO convert2SvcMeshFlowConfigDTO(SvcMeshFlowConfigDO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowConfigDTO svcMeshFlowConfigDTO = new SvcMeshFlowConfigDTO();

        svcMeshFlowConfigDTO.setId( request.getId() );
        svcMeshFlowConfigDTO.setFlowId( request.getFlowId() );
        svcMeshFlowConfigDTO.setConfig( request.getConfig() );
        svcMeshFlowConfigDTO.setTenantId( request.getTenantId() );
        svcMeshFlowConfigDTO.setVersion( request.getVersion() );
        svcMeshFlowConfigDTO.setCreateBy( request.getCreateBy() );
        svcMeshFlowConfigDTO.setCreateByName( request.getCreateByName() );
        svcMeshFlowConfigDTO.setCreateTime( request.getCreateTime() );
        svcMeshFlowConfigDTO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowConfigDTO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowConfigDTO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowConfigDTO;
    }

    @Override
    public List<SvcMeshFlowConfigDTO> convert2SvcMeshFlowConfigDTO(List<SvcMeshFlowConfigDO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowConfigDTO> list = new ArrayList<SvcMeshFlowConfigDTO>( request.size() );
        for ( SvcMeshFlowConfigDO svcMeshFlowConfigDO : request ) {
            list.add( convert2SvcMeshFlowConfigDTO( svcMeshFlowConfigDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowConfigDO convert2SvcMeshFlowConfigDO(SvcMeshFlowConfigDTO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowConfigDO svcMeshFlowConfigDO = new SvcMeshFlowConfigDO();

        svcMeshFlowConfigDO.setId( request.getId() );
        svcMeshFlowConfigDO.setFlowId( request.getFlowId() );
        svcMeshFlowConfigDO.setConfig( request.getConfig() );
        svcMeshFlowConfigDO.setTenantId( request.getTenantId() );
        svcMeshFlowConfigDO.setVersion( request.getVersion() );
        svcMeshFlowConfigDO.setCreateBy( request.getCreateBy() );
        svcMeshFlowConfigDO.setCreateByName( request.getCreateByName() );
        svcMeshFlowConfigDO.setCreateTime( request.getCreateTime() );
        svcMeshFlowConfigDO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowConfigDO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowConfigDO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowConfigDO;
    }

    @Override
    public List<SvcMeshFlowConfigDO> convert2SvcMeshFlowConfigDO(List<SvcMeshFlowConfigDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowConfigDO> list = new ArrayList<SvcMeshFlowConfigDO>( request.size() );
        for ( SvcMeshFlowConfigDTO svcMeshFlowConfigDTO : request ) {
            list.add( convert2SvcMeshFlowConfigDO( svcMeshFlowConfigDTO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowNodeDTO convert2SvcMeshFlowNodeDTO(SvcMeshFlowNodeDO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowNodeDTO svcMeshFlowNodeDTO = new SvcMeshFlowNodeDTO();

        svcMeshFlowNodeDTO.setId( request.getId() );
        svcMeshFlowNodeDTO.setFlowId( request.getFlowId() );
        svcMeshFlowNodeDTO.setNodeId( request.getNodeId() );
        svcMeshFlowNodeDTO.setCode( request.getCode() );
        svcMeshFlowNodeDTO.setNodeType( request.getNodeType() );
        svcMeshFlowNodeDTO.setConfig( request.getConfig() );
        svcMeshFlowNodeDTO.setTenantId( request.getTenantId() );
        svcMeshFlowNodeDTO.setVersion( request.getVersion() );
        svcMeshFlowNodeDTO.setCreateBy( request.getCreateBy() );
        svcMeshFlowNodeDTO.setCreateByName( request.getCreateByName() );
        svcMeshFlowNodeDTO.setCreateTime( request.getCreateTime() );
        svcMeshFlowNodeDTO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowNodeDTO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowNodeDTO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowNodeDTO;
    }

    @Override
    public List<SvcMeshFlowNodeDTO> convert2SvcMeshFlowNodeDTO(List<SvcMeshFlowNodeDO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowNodeDTO> list = new ArrayList<SvcMeshFlowNodeDTO>( request.size() );
        for ( SvcMeshFlowNodeDO svcMeshFlowNodeDO : request ) {
            list.add( convert2SvcMeshFlowNodeDTO( svcMeshFlowNodeDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowNodeDO convert2SvcMeshFlowNodeDO(SvcMeshFlowNodeDTO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowNodeDO svcMeshFlowNodeDO = new SvcMeshFlowNodeDO();

        svcMeshFlowNodeDO.setId( request.getId() );
        svcMeshFlowNodeDO.setFlowId( request.getFlowId() );
        svcMeshFlowNodeDO.setNodeId( request.getNodeId() );
        svcMeshFlowNodeDO.setCode( request.getCode() );
        svcMeshFlowNodeDO.setNodeType( request.getNodeType() );
        svcMeshFlowNodeDO.setConfig( request.getConfig() );
        svcMeshFlowNodeDO.setTenantId( request.getTenantId() );
        svcMeshFlowNodeDO.setVersion( request.getVersion() );
        svcMeshFlowNodeDO.setCreateBy( request.getCreateBy() );
        svcMeshFlowNodeDO.setCreateByName( request.getCreateByName() );
        svcMeshFlowNodeDO.setCreateTime( request.getCreateTime() );
        svcMeshFlowNodeDO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowNodeDO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowNodeDO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowNodeDO;
    }

    @Override
    public List<SvcMeshFlowNodeDO> convert2SvcMeshFlowNodeDO(List<SvcMeshFlowNodeDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowNodeDO> list = new ArrayList<SvcMeshFlowNodeDO>( request.size() );
        for ( SvcMeshFlowNodeDTO svcMeshFlowNodeDTO : request ) {
            list.add( convert2SvcMeshFlowNodeDO( svcMeshFlowNodeDTO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowInvokeLogDTO convert2SvcMeshFlowInvokeLogDTO(SvcMeshFlowInvokeLogDO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowInvokeLogDTO svcMeshFlowInvokeLogDTO = new SvcMeshFlowInvokeLogDTO();

        svcMeshFlowInvokeLogDTO.setId( request.getId() );
        svcMeshFlowInvokeLogDTO.setFlowId( request.getFlowId() );
        svcMeshFlowInvokeLogDTO.setSourceIp( request.getSourceIp() );
        svcMeshFlowInvokeLogDTO.setTargetIp( request.getTargetIp() );
        svcMeshFlowInvokeLogDTO.setRequest( request.getRequest() );
        svcMeshFlowInvokeLogDTO.setResponse( request.getResponse() );
        svcMeshFlowInvokeLogDTO.setLog( request.getLog() );
        svcMeshFlowInvokeLogDTO.setStatus( request.getStatus() );
        svcMeshFlowInvokeLogDTO.setTenantId( request.getTenantId() );
        svcMeshFlowInvokeLogDTO.setVersion( request.getVersion() );
        svcMeshFlowInvokeLogDTO.setCreateBy( request.getCreateBy() );
        svcMeshFlowInvokeLogDTO.setCreateByName( request.getCreateByName() );
        svcMeshFlowInvokeLogDTO.setCreateTime( request.getCreateTime() );
        svcMeshFlowInvokeLogDTO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowInvokeLogDTO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowInvokeLogDTO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowInvokeLogDTO;
    }

    @Override
    public List<SvcMeshFlowInvokeLogDTO> convert2SvcMeshFlowInvokeLogDTO(List<SvcMeshFlowInvokeLogDO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowInvokeLogDTO> list = new ArrayList<SvcMeshFlowInvokeLogDTO>( request.size() );
        for ( SvcMeshFlowInvokeLogDO svcMeshFlowInvokeLogDO : request ) {
            list.add( convert2SvcMeshFlowInvokeLogDTO( svcMeshFlowInvokeLogDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshFlowInvokeLogDO convert2SvcMeshFlowInvokeLogDO(SvcMeshFlowInvokeLogDTO request) {
        if ( request == null ) {
            return null;
        }

        SvcMeshFlowInvokeLogDO svcMeshFlowInvokeLogDO = new SvcMeshFlowInvokeLogDO();

        svcMeshFlowInvokeLogDO.setId( request.getId() );
        svcMeshFlowInvokeLogDO.setFlowId( request.getFlowId() );
        svcMeshFlowInvokeLogDO.setSourceIp( request.getSourceIp() );
        svcMeshFlowInvokeLogDO.setTargetIp( request.getTargetIp() );
        svcMeshFlowInvokeLogDO.setRequest( request.getRequest() );
        svcMeshFlowInvokeLogDO.setResponse( request.getResponse() );
        svcMeshFlowInvokeLogDO.setLog( request.getLog() );
        svcMeshFlowInvokeLogDO.setStatus( request.getStatus() );
        svcMeshFlowInvokeLogDO.setTenantId( request.getTenantId() );
        svcMeshFlowInvokeLogDO.setVersion( request.getVersion() );
        svcMeshFlowInvokeLogDO.setCreateBy( request.getCreateBy() );
        svcMeshFlowInvokeLogDO.setCreateByName( request.getCreateByName() );
        svcMeshFlowInvokeLogDO.setCreateTime( request.getCreateTime() );
        svcMeshFlowInvokeLogDO.setUpdateBy( request.getUpdateBy() );
        svcMeshFlowInvokeLogDO.setUpdateByName( request.getUpdateByName() );
        svcMeshFlowInvokeLogDO.setUpdateTime( request.getUpdateTime() );

        return svcMeshFlowInvokeLogDO;
    }

    @Override
    public List<SvcMeshFlowInvokeLogDO> convert2SvcMeshFlowInvokeLogDO(List<SvcMeshFlowInvokeLogDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshFlowInvokeLogDO> list = new ArrayList<SvcMeshFlowInvokeLogDO>( request.size() );
        for ( SvcMeshFlowInvokeLogDTO svcMeshFlowInvokeLogDTO : request ) {
            list.add( convert2SvcMeshFlowInvokeLogDO( svcMeshFlowInvokeLogDTO ) );
        }

        return list;
    }
}
