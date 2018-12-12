/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.shardingproxy.transport.mysql.packet.command.admin;

import shardingsphere.shaded.common.base.Optional;
import io.shardingsphere.shardingproxy.transport.mysql.constant.ServerErrorCode;
import io.shardingsphere.shardingproxy.transport.mysql.packet.MySQLPacketPayload;
import io.shardingsphere.shardingproxy.transport.mysql.packet.command.CommandPacket;
import io.shardingsphere.shardingproxy.transport.mysql.packet.command.CommandPacketType;
import io.shardingsphere.shardingproxy.transport.mysql.packet.command.CommandResponsePackets;
import io.shardingsphere.shardingproxy.transport.mysql.packet.generic.ErrPacket;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Unsupported command packet.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
public final class UnsupportedCommandPacket implements CommandPacket {
    
    @Getter
    private final int sequenceId;
    
    private final CommandPacketType type;
    
    @Override
    public Optional<CommandResponsePackets> execute() {
        return Optional.of(new CommandResponsePackets(new ErrPacket(getSequenceId() + 1, ServerErrorCode.ER_UNSUPPORTED_COMMAND, type)));
    }
    
    @Override
    public void write(final MySQLPacketPayload payload) {
    }
}
