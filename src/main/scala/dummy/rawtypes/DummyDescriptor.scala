package dummy.rawtypes

class DummyDescriptor extends BuildStepDescriptor {
  /*
  override def isApplicable(aClass: Class[_ <: AbstractProject]): Boolean = true
  */
  //[error] /Users/dcr/Dev/dustbin/src/main/scala/dummy/rawtypes/DummyDescriptor.scala:3: class DummyDescriptor needs to be abstract, since method isApplicable in class BuildStepDescriptor of type (jobType: Class[_ <: dummy.rawtypes.AbstractProject])Boolean is not defined
  //[error] (Note that Class[_ <: dummy.rawtypes.AbstractProject] does not match Class[_ <: dummy.rawtypes.AbstractProject[_, _]]: their type parameters differ
  
  
  
  /*
  override def isApplicable(aClass: Class[_ <: AbstractProject[_,_]]): Boolean = true
  */
  //[error] /Users/dcr/Dev/dustbin/src/main/scala/dummy/rawtypes/DummyDescriptor.scala:9: method isApplicable overrides nothing.
  //[error] Note: the super classes of class DummyDescriptor contain the following, non final members named isApplicable:
  //[error] private[package rawtypes] def isApplicable(jobType: Class[_ <: dummy.rawtypes.AbstractProject]): Boolean
  //[error]   override def isApplicable(aClass: Class[_ <: AbstractProject[_,_]]): Boolean = true


  
    import scala.language.existentials
    type Clazz = Class[_ <: AbstractProject[P, R]] forSome {
      type P <: AbstractProject[P,R]
      type R <: AbstractBuild[P,R]
    }
    override def isApplicable(aClass : Clazz):Boolean = true
  //[error] /Users/dcr/Dev/dustbin/src/main/scala/dummy/rawtypes/DummyDescriptor.scala:3: class DummyDescriptor needs to be abstract, since method isApplicable in class BuildStepDescriptor of type (jobType: Class[_ <: dummy.rawtypes.AbstractProject])Boolean is not defined
  //[error] (Note that Class[_ <: dummy.rawtypes.AbstractProject] does not match DummyDescriptor.this.Clazz: their type parameters differ)
  //[error] class DummyDescriptor extends BuildStepDescriptor {
  //[error]       ^
  //[error] /Users/dcr/Dev/dustbin/src/main/scala/dummy/rawtypes/DummyDescriptor.scala:26: method isApplicable overrides nothing.
  //[error] Note: the super classes of class DummyDescriptor contain the following, non final members named isApplicable:
  //[error] private[package rawtypes] def isApplicable(jobType: Class[_ <: dummy.rawtypes.AbstractProject]): Boolean
  //[error]     override def isApplicable(aClass : Clazz):Boolean = true    

}