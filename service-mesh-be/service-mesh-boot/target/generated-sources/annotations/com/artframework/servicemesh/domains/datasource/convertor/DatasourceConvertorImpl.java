package com.artframework.servicemesh.domains.datasource.convertor;

import com.artframework.servicemesh.domains.datasource.dto.DatasourceDTO;
import com.artframework.servicemesh.entities.SvcMeshDatasourceDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T21:13:36+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class DatasourceConvertorImpl implements DatasourceConvertor {

    private final DatasourceConvertorDecorator datasourceConvertorDecorator = new DatasourceConvertorDecorator();

    @Override
    public DatasourceDTO convert2DTO(SvcMeshDatasourceDO request) {
        if ( request == null ) {
            return null;
        }

        DatasourceDTO datasourceDTO = new DatasourceDTO();

        datasourceDTO.setId( request.getId() );
        datasourceDTO.setCode( request.getCode() );
        datasourceDTO.setName( request.getName() );
        datasourceDTO.setType( request.getType() );
        datasourceDTO.setConfig( request.getConfig() );
        datasourceDTO.setTenantId( request.getTenantId() );
        datasourceDTO.setVersion( request.getVersion() );
        datasourceDTO.setCreateBy( request.getCreateBy() );
        datasourceDTO.setCreateByName( request.getCreateByName() );
        datasourceDTO.setCreateTime( request.getCreateTime() );
        datasourceDTO.setUpdateBy( request.getUpdateBy() );
        datasourceDTO.setUpdateByName( request.getUpdateByName() );
        datasourceDTO.setUpdateTime( request.getUpdateTime() );

        return datasourceDTO;
    }

    @Override
    public List<DatasourceDTO> convert2DTO(List<SvcMeshDatasourceDO> request) {
        if ( request == null ) {
            return null;
        }

        List<DatasourceDTO> list = new ArrayList<DatasourceDTO>( request.size() );
        for ( SvcMeshDatasourceDO svcMeshDatasourceDO : request ) {
            list.add( convert2DTO( svcMeshDatasourceDO ) );
        }

        return list;
    }

    @Override
    public SvcMeshDatasourceDO convert2DO(DatasourceDTO request) {
        datasourceConvertorDecorator.before( request );

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

        datasourceConvertorDecorator.after( request, svcMeshDatasourceDO );

        return svcMeshDatasourceDO;
    }

    @Override
    public List<SvcMeshDatasourceDO> convert2DO(List<DatasourceDTO> request) {
        if ( request == null ) {
            return null;
        }

        List<SvcMeshDatasourceDO> list = new ArrayList<SvcMeshDatasourceDO>( request.size() );
        for ( DatasourceDTO datasourceDTO : request ) {
            list.add( convert2DO( datasourceDTO ) );
        }

        return list;
    }
}
