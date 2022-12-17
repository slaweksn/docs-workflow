package org.ib.was.docs.configs;

import java.util.Set;
import java.util.stream.Collectors;

import org.ib.was.docs.dto.AttachmentDTO;
import org.ib.was.docs.dto.DocumentDTO;
import org.ib.was.docs.models.Attachment;
import org.ib.was.docs.models.Document;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperDTO {

	@Bean
	public ModelMapper modelMapper() {

		ModelMapper mapper = new ModelMapper();

		TypeMap<Document, DocumentDTO> propertyDocumentMapper = mapper.createTypeMap(Document.class, DocumentDTO.class);

		propertyDocumentMapper.addMappings(
				m -> m.map(src -> src.getCustomer().getId(), DocumentDTO::setCustomerId));
		propertyDocumentMapper.addMappings(
				m -> m.map(src -> src.getName(), DocumentDTO::setName));
		propertyDocumentMapper.addMappings(
				m -> m.map(src -> src.getCustomer().getName(), DocumentDTO::setCustomerName));
		propertyDocumentMapper.addMappings(
				m -> m.using(new AttachmentsSetConverter(mapper)).map(Document::getAttachments, DocumentDTO::setAttachments)
		);
		
		TypeMap<Attachment, AttachmentDTO> propertyAttachmentMapper = mapper.createTypeMap(Attachment.class, AttachmentDTO.class);
		propertyAttachmentMapper.addMappings(
				m -> m.map(src -> src.getId(), AttachmentDTO::setId));
		propertyAttachmentMapper.addMappings(
				m -> m.map(src -> src.getName(), AttachmentDTO::setName));
		
		return mapper;
	}

	private class AttachmentsSetConverter extends AbstractConverter<Set<Attachment>, Set<AttachmentDTO>> {

		private ModelMapper mapper;
		
		public AttachmentsSetConverter(ModelMapper mapper) {
			super();
			this.mapper = mapper;
		}

		@Override
		protected Set<AttachmentDTO> convert(Set<Attachment> source) {
			
			if(source == null) 
				return null;
			
			return source.stream().map(p -> {
					return mapper.map(p, AttachmentDTO.class);
				}).collect(Collectors.toSet());
		}

	}
}
