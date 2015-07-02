package logic.coffee;

public class Resource {
	 protected int idResource;
	 protected String resourceType;
	 protected double pricePerServing;
	 protected int servingsLeft;// number of available portions
	 
	 @Override
	 public String toString(){
		StringBuilder sb =new StringBuilder();
		sb.append("ResourceID=");sb.append(idResource);
		sb.append("; resourceType=");
		sb.append(resourceType);
		sb.append("; pricePerServing=");
		sb.append(pricePerServing);
		sb.append("; servingsLeft=");
		sb.append(servingsLeft);
		return sb.toString();	 
	 }

	public void add(Resource r) {
		this.pricePerServing+=r.pricePerServing;
	}
	
	 @Override
	 public boolean equals(Object obj){
		 boolean ans=false;
		 if(this.resourceType.toLowerCase().equals(((Resource)obj).resourceType.toLowerCase())){
			 ans=true;
		 }
		return ans;
		 
	 }
}
