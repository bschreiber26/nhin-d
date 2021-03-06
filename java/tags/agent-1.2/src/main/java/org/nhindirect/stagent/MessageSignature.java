/* 
Copyright (c) 2010, NHIN Direct Project
All rights reserved.

Authors:
   Umesh Madan     umeshma@microsoft.com
   Greg Meyer      gm2552@cerner.com
 
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer 
in the documentation and/or other materials provided with the distribution.  Neither the name of the The NHIN Direct Project (nhindirect.org). 
nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.nhindirect.stagent;

import com.google.inject.ImplementedBy;

/**
 * Contains information specific to a discrete signer of a message.  Includes the singer information and the certificate used to sign the message (optimally
 * extracted from the signature).  This is a subset of the CMS signed data.
 * @author Greg Meyer
 * @author Umesh Madan
 *
 */
@ImplementedBy(DefaultMessageSignatureImpl.class)
public interface MessageSignature {
	
	/**
	 * Verifies if the signature is valid using the signature certificate.
	 * @return True if the signature is valid.  False otherwise.
	 */
	public boolean checkSignature();
	
	/**
	 * Validates if the senders certificate matches the signature certificate using certificate thumb printing.
	 * @param messageSender The senders address.  The address should contain the senders public certificate.
	 * @return True if the thumb print of the signature matches the senders certificate thumb print.  False otherwise.
	 */
	public boolean checkThumbprint(NHINDAddress messageSender);

}
