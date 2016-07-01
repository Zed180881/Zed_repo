package lesson04;

public class PersonalComputer {

	Cpu cpu = new Cpu();
	Ram ram = new Ram();
	SSD ssd;

	public PersonalComputer() {
	}

	public PersonalComputer(int cpuCountOfCores, int cpuMHz, int ramCapacity) {
		this.cpu = new Cpu(cpuCountOfCores, cpuMHz);
		this.ram = new Ram(ramCapacity);
	}

	public PersonalComputer(int cpuCountOfCores, int cpuMHz, int ramCapacity, int ssdCapacity) {
		this(cpuCountOfCores, cpuMHz, ramCapacity);
		this.ssd = new SSD(ssdCapacity);
	}
	
	public void bust(){
		cpu.bust();
	}

	public PersonalComputer(Cpu cpu, Ram ram, SSD ssd) {		
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public SSD getSsd() {
		return ssd;
	}

	public void setSsd(SSD ssd) {
		this.ssd = ssd;
	}

	@Override
	public String toString() {
		return "PersonalComputer [cpu=" + cpu + ", ram=" + ram + ", ssd=" + ssd
				+ "]";
	}

}
