package net.engining.pcx.cc.batch.cc1800;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Service;


/**
 * 计算应还本金（按周期计息的贷款，非按日计息）
 *
 */
@Service
@StepScope
public class Cc1800P369CountRepayAmt4Cycle extends AbstractCc1800P36CountRepay {

	protected Cc1800P369CountRepayAmt4Cycle()
	{
		super(false);
	}
}
