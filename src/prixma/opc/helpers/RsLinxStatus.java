package prixma.opc.helpers;

import prixma.opc.commands.ReadCommand;

public class RsLinxStatus {
	
	private final String topic;
	private final String ping;
	
	public RsLinxStatus(String topic) {
		this.topic = topic;
		this.ping = Configs.get("opc.connection.ping");
	}
	
	public String getProcessorMode() {
		return getValue("@Mode");
	}

	public String getProcessorStatus() {
		return getValue("@Status");
	}
	
	public String getProcessorType() {
		return getValue("@PLCType");
	}
	
	public String getFirmwareVersion() {
		return getValue("@Revision");
	}
	
	public String getProcessorName() {
		return getValue("@ProcessorName");
	}
	
	public String getPacketsSent() {
		return getValue("@PacketsSent");
	}
	
	public String getPacketsReceived() {
		return getValue("@PacketsReceived");
	}
	
	public String getPacketsCancelled() {
		return getValue("@PacketsCancelled");
	}
	
	public String getAveragePacketResponse() {
		return getValue("@AveragePacketResponse");
	}
	
	public String getBadUpdates() {
		return getValue("@BadUpdates");
	}
	
	public String getPacketsPerSecond() {
		return getValue("@PacketsPerSecond");
	}
	
	public String getTrendsReinitialized() {
		return getValue("@TrendsReinitialized");
	}
	
	public String getConnectionsActive() {
		return getValue("@ConnectionsActive");
	}
	
	public String getConnectionsDropped() {
		return getValue("@ConnectionsDropped");
	}
	
	public String getConnectionsAttempted() {
		return getValue("@ConnectionsAttempted");
	}
	
	public String getConnectionOpensFailed() {
		return getValue("@ConnectionOpensFailed");
	}
	
	public String getConnectionOpensRejected() {
		return getValue("@ConnectionOpensRejected");
	}
	
	public String getConnectionsClosed() {
		return getValue("@ConnectionsClosed");
	}
	
	public String getConnectionClosesFailed() {
		return getValue("@ConnectionClosesFailed");
	}
	
	public String getConnectionClosesRejected() {
		return getValue("@ConnectionClosesRejected");
	}
	
	public String getConnectionsUnknownState() {
		return getValue("@ConnectionsUnknownState");
	}
	
	public String getPollRequests() {
		return getValue("@PollRequests");
	}
	
	public String getPollRequestsPerSecond() {
		return getValue("@PollRequestsPerSecond");
	}
	
	public String getNumberOfItems() {
		return getValue("@NumberOfItems");
	}
	
	public String getNumberOfPredefinedItems() {
		return getValue("@NumberOfPredefinedItems");
	}
	
	public String getNumberOfDataItems() {
		return getValue("@NumberOfDataItems");
	}
	
	public String getNumberOfTrends() {
		return getValue("@NumberOfTrends");
	}
	
	public String getNumberOfPredefinedTrends() {
		return getValue("@NumberOfPredefinedTrends");
	}
	
	public String getNumberOfDataTrends() {
		return getValue("@NumberOfDataTrends");
	}
	
	public String ping() {
		return getValue(ping);
	}
	
	private String getValue(String tag){
		String address = "[" + this.topic + "]" + tag;
		return new ReadCommand<String>(address, "").execute();
	}
	
	private String getItem(String item){
		return "[" + this.topic + "]" + item;
	}

	public String getProcessorModeTag() {
		return getItem("@Mode");
	}
	
	public String getProcessorStatusTag() {
		return getItem("@Status");
	}
	
	public String getProcessorTypeTag() {
		return getItem("@PLCType");
	}
	
	public String getFirmwareVersionTag() {
		return getItem("@Revision");
	}
	
	public String getProcessorNameTag() {
		return getItem("@ProcessorName");
	}
	
	public String getPacketsSentTag() {
		return getItem("@PacketsSent");
	}
	
	public String getPacketsReceivedTag() {
		return getItem("@PacketsReceived");
	}
	
	public String getPacketsCancelledTag() {
		return getItem("@PacketsCancelled");
	}
	
	public String getAveragePacketResponseTag() {
		return getItem("@AveragePacketResponse");
	}
	
	public String getBadUpdatesTag() {
		return getItem("@BadUpdates");
	}
	
	public String getPacketsPerSecondTag() {
		return getItem("@PacketsPerSecond");
	}
	
	public String getTrendsReinitializedTag() {
		return getItem("@TrendsReinitialized");
	}
	
	public String getConnectionsActiveTag() {
		return getItem("@ConnectionsActive");
	}
	
	public String getConnectionsDroppedTag() {
		return getItem("@ConnectionsDropped");
	}
	
	public String getConnectionsAttemptedTag() {
		return getItem("@ConnectionsAttempted");
	}
	
	public String getConnectionOpensFailedTag() {
		return getItem("@ConnectionOpensFailed");
	}
	
	public String getConnectionOpensRejectedTag() {
		return getItem("@ConnectionOpensRejected");
	}
	
	public String getConnectionsClosedTag() {
		return getItem("@ConnectionsClosed");
	}
	
	public String getConnectionClosesFailedTag() {
		return getItem("@ConnectionClosesFailed");
	}
	
	public String getConnectionClosesRejectedTag() {
		return getItem("@ConnectionClosesRejected");
	}
	
	public String getConnectionsUnknownStateTag() {
		return getItem("@ConnectionsUnknownState");
	}
	
	public String getPollRequestsTag() {
		return getItem("@PollRequests");
	}
	
	public String getPollRequestsPerSecondTag() {
		return getItem("@PollRequestsPerSecond");
	}
	
	public String getNumberOfItemsTag() {
		return getItem("@NumberOfItems");
	}
	
	public String getNumberOfPredefinedItemsTag() {
		return getItem("@NumberOfPredefinedItems");
	}
	
	public String getNumberOfDataItemsTag() {
		return getItem("@NumberOfDataItems");
	}
	
	public String getNumberOfTrendsTag() {
		return getItem("@NumberOfTrends");
	}
	
	public String getNumberOfPredefinedTrendsTag() {
		return getItem("@NumberOfPredefinedTrends");
	}
	
	public String getNumberOfDataTrendsTag() {
		return getItem("@NumberOfDataTrends");
	}
	
	public String pingTag() {
		return getItem(ping);
	}
	

}
