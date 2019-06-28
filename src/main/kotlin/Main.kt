package main.kotlin

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.kstream.Produced
import java.util.*

fun main() {
    val props = Properties()
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "pensioenaangifte_app")
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9093")

    val builder = StreamsBuilder()
    builder.stream("berichten", Consumed.with(Serdes.String(), Serdes.String()))
            .mapValues { m -> m.toUpperCase() }.to("mutaties", Produced.with(Serdes.String(), Serdes.String()))

    builder.stream("mutaties", Consumed.with(Serdes.String(), Serdes.String())).print(Printed.toSysOut())

    val kafkaStreams = KafkaStreams(builder.build(), props)


    kafkaStreams.start()



}


