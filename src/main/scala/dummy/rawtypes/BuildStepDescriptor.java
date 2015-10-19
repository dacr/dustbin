package dummy.rawtypes;

public abstract class BuildStepDescriptor {
	abstract boolean isApplicable(Class<? extends AbstractProject> jobType);
}
