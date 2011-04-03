package prixma.opc.helpers;

import prixma.opc.commands.ReadCommand;

public class RsLinxStatus {
	
	private final String topic;
	private final String ping;
	
	public RsLinxStatus(String topic, String ping) {
		this.topic = topic;
		this.ping = ping;
	}
	
	public RsLinxStatus(String topic) {
		this.topic = topic;
		this.ping = Configs.getValue("opc.connection.ping.tag");
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
	
	private String getTag(String tag){
		return "[" + this.topic + "]" + tag;
	}

	public String getProcessorModeTag() {
		return getTag("@Mode");
	}
	
	public String getProcessorStatusTag() {
		return getTag("@Status");
	}
	
	public String getProcessorTypeTag() {
		return getTag("@PLCType");
	}
	
	public String getFirmwareVersionTag() {
		return getTag("@Revision");
	}
	
	public String getProcessorNameTag() {
		return getTag("@ProcessorName");
	}
	
	public String getPacketsSentTag() {
		return getTag("@PacketsSent");
	}
	
	public String getPacketsReceivedTag() {
		return getTag("@PacketsReceived");
	}
	
	public String getPacketsCancelledTag() {
		return getTag("@PacketsCancelled");
	}
	
	public String getAveragePacketResponseTag() {
		return getTag("@AveragePacketResponse");
	}
	
	public String getBadUpdatesTag() {
		return getTag("@BadUpdates");
	}
	
	public String getPacketsPerSecondTag() {
		return getTag("@PacketsPerSecond");
	}
	
	public String getTrendsReinitializedTag() {
		return getTag("@TrendsReinitialized");
	}
	
	public String getConnectionsActiveTag() {
		return getTag("@ConnectionsActive");
	}
	
	public String getConnectionsDroppedTag() {
		return getTag("@ConnectionsDropped");
	}
	
	public String getConnectionsAttemptedTag() {
		return getTag("@ConnectionsAttempted");
	}
	
	public String getConnectionOpensFailedTag() {
		return getTag("@ConnectionOpensFailed");
	}
	
	public String getConnectionOpensRejectedTag() {
		return getTag("@ConnectionOpensRejected");
	}
	
	public String getConnectionsClosedTag() {
		return getTag("@ConnectionsClosed");
	}
	
	public String getConnectionClosesFailedTag() {
		return getTag("@ConnectionClosesFailed");
	}
	
	public String getConnectionClosesRejectedTag() {
		return getTag("@ConnectionClosesRejected");
	}
	
	public String getConnectionsUnknownStateTag() {
		return getTag("@ConnectionsUnknownState");
	}
	
	public String getPollRequestsTag() {
		return getTag("@PollRequests");
	}
	
	public String getPollRequestsPerSecondTag() {
		return getTag("@PollRequestsPerSecond");
	}
	
	public String getNumberOfItemsTag() {
		return getTag("@NumberOfItems");
	}
	
	public String getNumberOfPredefinedItemsTag() {
		return getTag("@NumberOfPredefinedItems");
	}
	
	public String getNumberOfDataItemsTag() {
		return getTag("@NumberOfDataItems");
	}
	
	public String getNumberOfTrendsTag() {
		return getTag("@NumberOfTrends");
	}
	
	public String getNumberOfPredefinedTrendsTag() {
		return getTag("@NumberOfPredefinedTrends");
	}
	
	public String getNumberOfDataTrendsTag() {
		return getTag("@NumberOfDataTrends");
	}
	
	public String pingTag() {
		return getTag(ping);
	}
	

}
