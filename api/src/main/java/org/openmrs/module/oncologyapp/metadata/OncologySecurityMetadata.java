package org.openmrs.module.oncologyapp.metadata;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.idSet;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.privilege;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.role;

/**
 * Implementation of access control to the app.
 */
@Component
@Requires(org.openmrs.module.kenyaemr.metadata.SecurityMetadata.class)
public class OncologySecurityMetadata extends AbstractMetadataBundle {
	
	public static class _Privilege {
		
		public static final String APP_ONCOLOGY_APP = "App: oncologyapp.cancer";
	}
	
	public static final class _Role {
		
		public static final String APPLICATION_ONCOLOGY_MODULE = "EHR Oncology";
	}
	
	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		install(privilege(_Privilege.APP_ONCOLOGY_APP, "Able to access Key EHR Oncology  module features"));
		install(role(_Role.APPLICATION_ONCOLOGY_MODULE, "Can access EHR oncology module Application",
		    idSet(org.openmrs.module.kenyaemr.metadata.SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.APP_ONCOLOGY_APP)));
	}
}
